import java.util.Scanner;
import java.text.DateFormat;
import java.util.Date;

public class Main {

    static class Data {
        private int pergunteLimitado(int n1, int n2, String prompt) {
            Scanner pergunte = new Scanner(System.in);
            System.out.print(prompt);
            int val = pergunte.nextInt();
            while (val < n1 || val > n2) {
                System.out.print("Digite novamente: ");
                val = pergunte.nextInt();
            }
            return val;
        }
        
        private String[] meses = {"janeiro", "fevereiro", "marco", "abril", "maio", "junho", "julho", "agosto", "setembro", "outubro", "novembro", "dezembro"};
        private Scanner pergunte = new Scanner(System.in);
                
        private int dia;
        private int mes;
        private int ano;
        
        Data() {
            this.dia = pergunteLimitado(1, 31, "Dia: ");
            this.mes = pergunteLimitado(1, 12, "Mes: ");
            System.out.print("Ano: ");
            this.ano = pergunte.nextInt();
        }
        Data(int d, int m, int a) {
            this.dia = d;
            this.mes = m;
            this.ano = a;
        }
        void entraDia(int d) {
            this.dia = d;
        }
        void entraMes(int m) {
            this.mes = m;
        }
        void entraAno(int a) {
            this.ano = a;
        }
        void entraDia() {
            this.dia = pergunteLimitado(1, 31, "Dia: ");
        }
        void entraMes() {
            this.mes = pergunteLimitado(1, 12, "Mes: ");
        }
        void entraAno() {
            System.out.print("Ano: ");
            this.ano = pergunte.nextInt();
        }
        int retDia() {
            return this.dia;
        }
        int retMes() {
            return this.mes;
        }
        int retAno() {
            return this.ano;
        }
        String mostra1() {
            return (Integer.toString(this.dia) + "/" +  Integer.toString(this.mes) + "/" +  Integer.toString(this.ano));
        }
        String mostra2() {
            return (Integer.toString(this.dia) + "/" +  meses[this.mes - 1] + "/" +  Integer.toString(this.ano));
        }
        boolean bissexto() {
            return (this.ano % 4 == 0);
        }
        int diasTranscorridos() {
            return (((this.mes - 1) * 30) + this.dia);
        }
        void apresentaDataAtual () {
            DateFormat dateFormat = DateFormat.getTimeInstance(DateFormat.FULL);
            Date myDate = new Date();
            myDate.setYear(this.ano);
            myDate.setMonth(this.mes);
            myDate.setDate(this.dia);
            System.out.println(dateFormat.format(myDate));
        }
    }

    static class Hora {
        private int hora;
        private int min;
        private int seg;
    
        public Hora() {
            this.hora = pergunteLimitado(0, 23, "Hora: ");
            this.min = pergunteLimitado(0, 59, "Minuto: ");
            this.seg = pergunteLimitado(0, 59, "Segundo: ");
        }
    
        public Hora(int hora, int min, int seg) {
            this.hora = hora;
            this.min = min;
            this.seg = seg;
        }
    
        private int pergunteLimitado(int n1, int n2, String prompt) {
            Scanner pergunte = new Scanner(System.in);
            System.out.print(prompt);
            int val = pergunte.nextInt();
            while (val < n1 || val > n2) {
                System.out.print("Digite novamente: ");
                val = pergunte.nextInt();
            }
            return val;
        }
    
        public void setHor(int hora) {
            this.hora = hora;
        }
    
        public void setMin(int min) {
            this.min = min;
        }
    
        public void setSeg(int seg) {
            this.seg = seg;
        }
    
        public void setHor() {
            this.hora = pergunteLimitado(0, 23, "Hora: ");
        }
    
        public void setMin() {
            this.min = pergunteLimitado(0, 59, "Minuto: ");
        }
    
        public void setSeg() {
            this.seg = pergunteLimitado(0, 59, "Segundo: ");
        }
    
        public int getHor() {
            return this.hora;
        }
    
        public int getMin() {
            return this.min;
        }
    
        public int getSeg() {
            return this.seg;
        }
    
        public String getHora1() {
            return String.format("%02d:%02d:%02d", this.hora, this.min, this.seg);
        }
    
        public String getHora2() {
            int hour = this.hora;
            String suffix = "AM";
    
            if (hour == 0) {
                hour = 12;
            } else if (hour == 12) {
                suffix = "PM";
            } else if (hour > 12) {
                hour -= 12;
                suffix = "PM";
            }
    
            return String.format("%02d:%02d:%02d %s", hour, this.min, this.seg, suffix);
        }
    
        public int getSegundos() {
            return (this.hora * 3600) + (this.min * 60) + this.seg;
        }
    }

    static class ConsultaAgendada {
        private Data data;
        private Hora hora;
        private String nomePaciente;
        private static int quantidade = 0;
        private String nomeMedico;

        public ConsultaAgendada() {
            this.data = new Data();
            this.hora = new Hora();
            Scanner pergunte = new Scanner(System.in);
            System.out.print("Nome do paciente: ");
            this.nomePaciente = pergunte.nextLine();
            System.out.print("Nome do médico: ");
            this.nomeMedico = pergunte.nextLine();
            quantidade++;
        }

        public ConsultaAgendada(int h, int mi, int s, int d, int m, int a, String p, String med) {
            this.hora = new Hora(h, mi, s);
            this.data = new Data(d, m, a);
            this.nomePaciente = p;
            this.nomeMedico = med;
            quantidade++;
        }

        public ConsultaAgendada(Data d, Hora h, String p, String med) {
            this.hora = h;
            this.data = d;
            this.nomePaciente = p;
            this.nomeMedico = med;
            quantidade++;
        }
    
        public void setData(int a, int b, int c) {
            this.data = new Data(a, b, c);
        }
    
        public void setData() {
            this.data = new Data();
        }
    
        public void setHora(int a, int b, int c) {
            this.hora = new Hora(a, b, c);
        }
    
        public void setHora() {
            this.hora = new Hora();
        }
    
        public void setNomePaciente(String p) {
            this.nomePaciente = p;
        }
    
        public void setNomePaciente() {
            Scanner pergunte = new Scanner(System.in);
            System.out.print("Nome do paciente: ");
            this.nomePaciente = pergunte.nextLine();
        }
    
        public void setNomeMedico(String m) {
            this.nomeMedico = m;
        }
    
        public void setNomeMedico() {
            Scanner pergunte = new Scanner(System.in);
            System.out.print("Nome do médico: ");
            this.nomeMedico = pergunte.nextLine();
        }
    
        public int getQuantidade() {
            return quantidade;
        }
    
        public String getData() {
            return this.data.mostra1();
        }
    
        public String getHora() {
            return this.hora.getHora1();
        }
    
        public String getNomePaciente() {
            return this.nomePaciente;
        }
    
        public String getNomeMedico() {
            return this.nomeMedico;
        }
    }

    public static void main(String[] args) {
        // Passo 1: Criando o objeto p1 com o construtor especificado
        ConsultaAgendada p1 = new ConsultaAgendada(10, 30, 0, 25, 6, 2023, "Paciente 1", "Dr. A");

        // Passo 2: Exibindo todas as propriedades de p1
        System.out.println("\nDados da consulta p1 (antes da alteração):");
        System.out.println("Data: " + p1.getData());
        System.out.println("Hora: " + p1.getHora());
        System.out.println("Paciente: " + p1.getNomePaciente());
        System.out.println("Médico: " + p1.getNomeMedico());

        // Passo 3: Criando o objeto p2 com o construtor padrão
        ConsultaAgendada p2 = new ConsultaAgendada();

        // Passo 4: Exibindo todas as propriedades de p2
        System.out.println("\nDados da consulta p2:");
        System.out.println("Data: " + p2.getData());
        System.out.println("Hora: " + p2.getHora());
        System.out.println("Paciente: " + p2.getNomePaciente());
        System.out.println("Médico: " + p2.getNomeMedico());

        // Passo 5: Alterando as propriedades de p1
        p1.setData(26, 6, 2023);
        p1.setHora(11, 45, 0);
        p1.setNomePaciente("Paciente Alterado");
        p1.setNomeMedico("Dr. B");

        // Passo 6: Exibindo todas as propriedades de p1 após as alterações
        System.out.println("\nDados da consulta p1 (após a alteração):");
        System.out.println("Data: " + p1.getData());
        System.out.println("Hora: " + p1.getHora());
        System.out.println("Paciente: " + p1.getNomePaciente());
        System.out.println("Médico: " + p1.getNomeMedico());

        // Passo 7: Exibindo a quantidade final de consultas
        System.out.println("\nQuantidade final de consultas: " + p1.getQuantidade());
    }
}
