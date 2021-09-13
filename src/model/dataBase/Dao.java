
package model.dataBase;

/**
 * Clase abstracta que moldea un DAO
 * @param <T>
 */
public abstract class Dao<T extends Dto>
{

    protected void Dto(){}

    public String insert(Dto data)
    {
        return data.insert();
    }


}
