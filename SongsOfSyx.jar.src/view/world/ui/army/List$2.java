/*     */ package view.world.ui.army;
/*     */ 
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCES;
/*     */ import init.resources.ResSupply;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
/*     */ import world.army.AD;
/*     */ import world.army.ADSupply;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   extends GStat
/*     */ {
/*     */   public void update(GText text) {
/*  87 */     int am = 0;
/*  88 */     for (ResSupply res : (RESOURCES.SUP()).ALL) {
/*  89 */       am += (SETT.ROOMS()).SUPPLY.tally.amount.total(res.resource);
/*     */     }
/*     */     
/*  92 */     GFORMAT.iIncr(text, am);
/*     */   }
/*     */   
/*  95 */   RBIT.RBITImp rs = new RBIT.RBITImp();
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GBox b) {
/*  99 */     b.title(Dic.¤¤Supplies);
/* 100 */     b.text(Dic.¤¤SuppliesD);
/* 101 */     b.sep();
/*     */ 
/*     */     
/* 104 */     b.tab(1);
/* 105 */     b.textLL(Dic.¤¤Current);
/* 106 */     b.tab(4);
/* 107 */     b.textLL(Dic.¤¤Needed);
/* 108 */     b.tab(7);
/* 109 */     b.textLL(Dic.¤¤Consumed);
/* 110 */     b.tab(10);
/* 111 */     b.textLL(Dic.¤¤Available);
/* 112 */     b.NL();
/*     */     
/* 114 */     this.rs.clear();
/* 115 */     for (ResSupply supp : (RESOURCES.SUP()).ALL) {
/* 116 */       b.add((SPRITE)supp.resource.icon());
/* 117 */       ADSupply sup = AD.supplies().get(supp);
/* 118 */       b.tab(1);
/* 119 */       b.add((SPRITE)GFORMAT.i(b.text(), sup.current().faction(List.this.f)));
/* 120 */       b.tab(4);
/* 121 */       b.add((SPRITE)GFORMAT.i(b.text(), sup.targetAmount(List.this.f)));
/* 122 */       b.tab(7);
/* 123 */       b.add((SPRITE)GFORMAT.f0(b.text(), -sup.consumedPerDayCurrent(List.this.f)));
/* 124 */       b.tab(10);
/* 125 */       b.add((SPRITE)GFORMAT.i(b.text(), (SETT.ROOMS()).SUPPLY.tally.amount.total(supp.resource)));
/* 126 */       b.NL();
/*     */     } 
/* 128 */     b.NL(8);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\army\List$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */