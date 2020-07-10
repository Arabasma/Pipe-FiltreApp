package sample;

public class Operation {

    private int operande1;
    private int operande2;
    private char operation;
    private int resultat;

    public Operation (int operande1,int operande2,char operation)
    {
        this.operande1 = operande1;
        this.operande2 = operande2;
        this.operation = operation;
        resultat =0;

    }

    public char getOperation() {
        return operation;
    }

    public int getOperande1() {
        return operande1;
    }

    public int getOperande2() {
        return operande2;
    }

    public int getResultat() {
        return resultat;
    }

    public void setResultat(int resultat) {
        this.resultat = resultat;
    }

    public String operationTostring()
    {
        if (operation == 'f')
        { return ("Operation : "+this.operation+ " operande : "+this.operande1+" résultat : "+this.resultat );}
        else
        {
            return ("Operation : "+this.operation+ " operande 1 : "+this.operande1+" operande 2 : "+this.operande2+" résultat : "+this.resultat );
        }
    }
}
