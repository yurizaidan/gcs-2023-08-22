public class Taxpayer {
    
    private String name, scn;
    private int age, dependents;
    private double income, contribution;
   
    public Taxpayer(String name, String scn, double income, double contribution) {
        this.name = name;
        this.scn = scn;
        this.income = income;
        this.contribution = contribution;
    }
   
    public Taxpayer(String name, String scn, int age, int dependents, double income, double contribution) {
        this.name = name;
        this.scn = scn;
        this.age = age;
        this.dependents = dependents;
        this.income = income;
        this.contribution = contribution;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getScn() {
        return scn;
    }
    public void setScn(String scn) {
        this.scn = scn;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getDependents() {
        return dependents;
    }
    public void setDependents(int dependents) {
        this.dependents = dependents;
    }
    public double getIncome() {
        return income;
    }
    public void setIncome(int income) {
        this.income = income;
    }
    public double getContribution() {
        return contribution;
    }
    public void setContribution(int contribution) {
        this.contribution = contribution;
    }   

    public String toString () {
        return "\n*** Taxpayer name: "+this.getName()+"\n*** Tax payer social security number: "+this.getScn()+"\n*** Taxpayer total income: R$"+this.getIncome()+"\n*** Taxpayer total contribution: R$"+this.getContribution();
    }

    public static double standardTaxDeduction (double income, double contribution){
        double tax_due=0; 
        double base_value=(income-contribution)*0.95; 

        if (base_value<=12_000){
            tax_due=0;
        }
        else if (base_value>12_000 && base_value <=24_000){
            tax_due=(base_value-12_000)*0.15;
        }
        else if (base_value>24_000){
            tax_due=(base_value-24_000)*0.275;

        }

        return tax_due;

    }

    public static double itemizedTaxDeduction (double income, double contribution, int age, int dependents){
        double tax_due=0;
        double base_value=income-contribution;

        if (age<65 && dependents<=2){
            double base_value_after_discount=base_value*0.98;
            if (base_value_after_discount<=12_000){
                tax_due=0;
            }
            else if (base_value_after_discount>12_000 && base_value_after_discount <=24_000){
                tax_due=(base_value_after_discount-12_000)*0.15;
            }
            else if (base_value_after_discount>24_000){
                tax_due=(base_value_after_discount-24_000)*0.275;
            }
        }
        else if (age<65 && dependents>2 & dependents<=5){
            double base_value_after_discount=base_value*0.965;
            if (base_value_after_discount<=12_000){
                tax_due=0;
            }
            else if (base_value_after_discount>12_000 && base_value_after_discount <=24_000){
                tax_due=(base_value_after_discount-12_000)*0.15;
            }
            else if (base_value_after_discount>24_000){
                tax_due=(base_value_after_discount-24_000)*0.275;
            }

        }

        else if (age<65 && dependents>5){
            double base_value_after_discount=base_value*0.95;
            if (base_value_after_discount<=12_000){
                tax_due=0;
            }
            else if (base_value_after_discount>12_000 && base_value_after_discount <=24_000){
                tax_due=(base_value_after_discount-12_000)*0.15;
            }
            else if (base_value_after_discount>24_000){
                tax_due=(base_value_after_discount-24_000)*0.275;
            }           
        }

        else if (age>=65 && dependents<=2){
            double base_value_after_discount=base_value*0.97;
            if (base_value_after_discount<=12_000){
                tax_due=0;
            }
            else if (base_value_after_discount>12_000 && base_value_after_discount <=24_000){
                tax_due=(base_value_after_discount-12_000)*0.15;
            }
            else if (base_value_after_discount>24_000){
                tax_due=(base_value_after_discount-24_000)*0.275;
            }
        }
        else if (age>=65 && dependents>2 & dependents<=5){
            double base_value_after_discount=base_value*0.955;
            if (base_value_after_discount<=12_000){
                tax_due=0;
            }
            else if (base_value_after_discount>12_000 && base_value_after_discount <=24_000){
                tax_due=(base_value_after_discount-12_000)*0.15;
            }
            else if (base_value_after_discount>24_000){
                tax_due=(base_value_after_discount-24_000)*0.275;
            }
        }
        else if (age>=65 && dependents>5){
            double base_value_after_discount=base_value*0.94;
            if (base_value_after_discount<=12_000){
                tax_due=0;
            }
            else if (base_value_after_discount>12_000 && base_value_after_discount <=24_000){
                tax_due=(base_value_after_discount-12_000)*0.15;
            }
            else if (base_value_after_discount>24_000){
                tax_due=(base_value_after_discount-24_000)*0.275;
            }
        }

        return tax_due;

    }
    
}

/*
Um sistema é usado para o cadastramento de contribuintes (pessoas físicas) e cálculo do imposto de renda. O cálculo pode ser feito
visando a declaração completa ou a declaração simplificada. Os dados necessários para a declaração completa são:
• Nome*
• CPF*
• Idade**
• Número de dependentes**
• Contribuição previdenciária oficial***
• Total de rendimentos***
*Campos obrigatórios para todos os contribuintes
**Campos obrigatórios para os contribuintes que fazem declaração completa ***Campos obrigatórios para permitir o cálculo do imposto (qualquer modalidade)

A base de cálculo é obtida descontando-se do total de rendimentos a contribuição previdenciária oficial.
• Aplica-se um desconto único de 5% sobre a base de cálculo.
• O imposto a pagar é obtido a partir da base de cálculo:
    • Se a base de cálculo é de até R$ 12.000,00 então o contribuinte está isento (imposto a pagar zero).
    • Se a base de cálculo for maior que R$ 12.000,00 e inferior a R$ 24.000,00, então o imposto a pagar corresponde a 15% do valor da base de cálculo
       que excede o valor da faixa anterior.
    • Se a base de cálculo for maior ou igual a R$ 24.000,00, então o imposto a pagar é equivalente ao imposto devido na faixa anterior mais 27,5% do valor
       da base de cálculo que excede a faixa anterior.
Cálculo do imposto (declaração completa)
     • A base de cálculo é obtida descontando-se do total de rendimentos a contribuição previdenciária oficial.
     • Em função da idade e do número de dependentes do contribuinte devese aplicar um desconto sobre a base de cálculo.
     • Para contribuintes com menos de 65 anos o desconto é de: 
               • 2% se o contribuinte tem até 2 dependentes
               • 3,5% se contribuinte tem entre 3 e 5 dependentes
               • 5% se o contribuinte tem mais de 5 dependentes
     • Para contribuintes com 65 anos ou mais o desconto é de:
                • 3% se o contribuinte tem até 2 dependentes
                • 4,5% se contribuinte tem entre 3 e 5 dependentes
                • 6% se o contribuinte tem mais de 5 dependentes
• O imposto a pagar é obtido a partir da base de cálculo:
              • Se a base de cálculo é de até R$ 12.000,00 então o contribuinte está isento (imposto a pagar zero).
               • Se a base de cálculo for maior que R$ 12.000,00 e inferior a R$ 24.000,00, então o imposto a pagar corresponde
                   a 15% do valor da base de cálculo que excede o valor da faixa anterior.
               • Se a base de cálculo for maior ou igual a R$ 24.000,00, então o imposto a pagar é equivalente ao imposto
                  devido na faixa anterior mais 27,5% do valor da base de cálculo que excede a faixa anterior. 
 */
