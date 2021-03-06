package ged.daedaluswin.crmclient.serverobjects.pojos;

/**
 * Created by Romanos Trechlis on 5/4/2015.
 */
public class TaxOffices {
    private int id;
    private int code;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TaxOffices that = (TaxOffices) o;

        if (code != that.code) return false;
        if (id != that.id) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + code;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
