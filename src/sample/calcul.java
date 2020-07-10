package sample;
public class calcul extends Filter {
    PipeObjet _dataINPipe;
    PipeObjet _dataOUTPipe;
    PipeResultat _resultatOUT;

    public calcul(PipeObjet _dataINPipe, PipeObjet _dataOUTPipe, PipeResultat _resultatOUT) {
        super();
        this._dataINPipe = _dataINPipe;
        this._dataOUTPipe = _dataOUTPipe;
        this._resultatOUT = _resultatOUT;
    }

    public Operation getData()
    {
        return _dataINPipe.dataOUT();
    }

    public void sendData( Operation resultat){
        _dataOUTPipe.dataIN(resultat);

    }

    @Override
    public void run() {

        execute();
    }
    @Override
    synchronized void execute() {
        while (true) {
            Operation op = this.getData();
            System.out.println(" on est la");
            int result = 1;
            if (op.getResultat() == 0) {
                if (op.getOperation() == 'f') {
                    for (int factor = 2; factor <= op.getOperande1(); factor++) {
                        result *= factor;
                    }
                } else if (op.getOperation() == 's') {
                    result = op.getOperande1() + op.getOperande2();
                    System.out.println("on est ici");
                } else {
                    result = op.getOperande1() * op.getOperande2();
                }

                op.setResultat(result);
                //_dataINPipe.dataIN(op);
                _resultatOUT.dataIN(result);
                this.sendData(op);
            }
        }
    }
}
