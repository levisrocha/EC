package testeJTabel;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Iterator;

public class ElementoTableModel extends AbstractTableModel {
    
    /** índice da coluna referente a símbolo. */
    public static final int SIMBOLO_INDEX = 0;
    /** índice da coluna referente a nome. */
    public static final int NOME_INDEX = 1;
    /** índice da coluna referente a número atômico. */
    public static final int NUMERO_ATOMICO_INDEX = 2;
    /** índice da coluna referente a massa atômica. */
    public static final int MASSA_ATOMICA_INDEX = 3;
    /** índice da coluna referente a número de períodos. */
    public static final int NUM_DE_PERIODOS_INDEX = 4;
    /** índice da coluna referente a família. */
    public static final int FAMILIA_INDEX = 5;
    /** índice da coluna referente a chave primária da tabela Elemento. */
    public static final int ID_INDEX = 6;
    
    private ArrayList linhas = null;
    private String[] colunas = null;
    
    /** Cria uma nova instância de ElementoTableModel */
    public ElementoTableModel() {}
 
    /**
     * Cria uma nova instancia de ElementoTableModel.
     * @param dados valores dos dados a serem inseridos nas linhas da tabela
     * @param colunas valores das colunas da tabela
     */
    public ElementoTableModel(ArrayList dados, String[] colunas) {
        setLinhas(dados);
        setColunas(colunas);
    }
    /**
     * Obtem o valor na linha e coluna.
     * @return objeto pesquisado
     * @see javax.swing.table.TableModel#getValueAt(int, int)
     */
    public Object getValueAt(int rowIndex, int columnIndex){
        // Obtem a linha, que eh uma String []
        String[] linha = (String[]) getLinhas().get(rowIndex);
        // Retorna o objeto que esta na coluna
        return linha[columnIndex];
    }
    /**
     * Retorna as colunas presentes no modelo.
     * @return array com as colunas presentes no modelo
     */
    public String[] getColunas(){return colunas;}
    /**
     * Retorna as linhas presentes no modelo.
     * @return array com as linhas presentes no modelo
     */
    public ArrayList getLinhas(){return linhas;}
    /**
     * Modifica as colunas presentes no modelo.
     * @param strings - array de valores a serem inseridos nas colunas da tabela
     */
    public void setColunas(String[] strings){colunas = strings;}
    /**
     * Modifica as linhas presentes no modelo.
     * @param list lista de valores a serem inseridos nas linhas da tabela
     */
    public void setLinhas(ArrayList list){linhas = list;}
    /**
     * Retorna o numero de colunas no modelo.
     * @return quantidade de colunas presentes no modelo
     * @see javax.swing.table.TableModel#getColumnCount
     */
    public int getColumnCount(){return this.getColunas().length;}
    /**
     * Retorna o numero de linhas existentes no modelo.
     * @return quantidade de linhas presentes no modelo
     * @see javax.swing.table.TableModel#getRowCount
     */
    public int getRowCount(){return this.getLinhas().size();}
    /**
     * Adiciona nova linha no modelo.
     * @param dadosLinha array de dados da linha a ser inserida
     */
    public void addRow(String[] dadosLinha){
        int linha = this.getLinhas().size() - 1;
        this.fireTableRowsInserted(linha,linha);
        return;
    }
    /**
     * Remove linha no modelo.
     * @param row índice da linha a ser removida do modelo
     */
    public void removeRow(int row){
        this.getLinhas().remove(row);
        // informa a JTable que houve dados deletados passando a linha removida
        this.fireTableRowsDeleted(row,row);     
    }
    /**
     * Remove a linha pelo valor da coluna informada.
     * @param val valor do elemento a ser pesquisado
     * @param col índice da coluna a ser pesquisada
     * @return true - se removeu, false - caso negativo
     */
    public boolean removeRow(String val, int col){
        // obtem o Iterator
        Iterator i = this.getLinhas().iterator();
        int linha = -1;
        // loop acerca das linhas
        while(i.hasNext()){
            // obtem as colunas da linha atual
            String[] linhaCorrente = (String[]) i.next();
            linha++;
            // compara o conteudo da linha atual na coluna desejada com o valor informado
            if(linhaCorrente[col].equals(val)){
                this.getLinhas().remove(linha);
                // informa a jtable que houve dados deletados passando a 
                // linha removida
                this.fireTableRowsDeleted(linha,linha);
                return true;
            }
            
        }
        // Nao encontrou nada
        return false;
    }
    /**
     * Retorna o nome da coluna.
     * @param col índice da coluna a ser removida
     * @return nome da coluna pesquisada
     */
    public String getColumnName(int col){
        return this.getColunas()[col];
    }
    
}
