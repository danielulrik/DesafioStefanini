
package br.com.ulrik.stefanini_desafio.model.api;


import java.io.Serializable;

public class Weather implements Serializable {

    private String description;
    private String icon;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

}
