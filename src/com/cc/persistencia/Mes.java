package com.cc.persistencia;

import java.util.List;

public class Mes {
  
  private long id;
  private double valorCota;
  private int qtdDiasFolga;
  private List<VendaPorDia> vendas;
  
  public long getId() {
    return id;
  }
  
  public void setId(long id) {
    this.id = id;
  }
  
  public double getValorCota() {
    return valorCota;
  }
  
  public void setValorCota(double valorCota) {
    this.valorCota = valorCota;
  }
  
  public List<VendaPorDia> getVendas() {
    return vendas;
  }
  
  public void setVendas(List<VendaPorDia> vendas) {
    this.vendas = vendas;
  }

  public int getQtdDiasFolga() {
    return qtdDiasFolga;
  }

  public void setQtdDiasFolga(int qtdDiasFolga) {
    this.qtdDiasFolga = qtdDiasFolga;
  }
  
  
  

}
