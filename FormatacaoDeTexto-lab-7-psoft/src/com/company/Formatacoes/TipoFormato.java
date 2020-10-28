package com.company.Formatacoes;

import com.company.Formato;

public enum TipoFormato {
    MAIUSCULO {
        @Override
        public Formato obterFormato(){
            return new Maiusculo();
        }
    },

    MINUSCULO {
        @Override
        public Formato obterFormato(){
            return new Minusculo();
        }
    },

    NEGRITO {
        @Override
        public Formato obterFormato(){
            return new Negrito();
        }
    },

    ITALICO {
        @Override
        public Formato obterFormato(){
            return new Italico();
        }
    };

    public abstract Formato obterFormato();
}
