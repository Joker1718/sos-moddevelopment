/*     */ package world.army;
/*     */ 
/*     */ import settlement.stats.equip.EquipBattle;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
/*     */ import world.entity.army.WArmy;
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
/*     */ public final class ADSupplyEquip
/*     */   extends ADSupply
/*     */ {
/*     */   public final EquipBattle equip;
/*     */   
/*     */   ADSupplyEquip(int index, ADInit init, EquipBattle rs) {
/* 323 */     super(index, "EQUIPMENT", init, rs.resource, Dic.¤¤Equipment, 0.0D, rs.wearRate() / 16.0D, 0.0D, 0.0D);
/* 324 */     this.equip = rs;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void add(WArmy a) {
/* 329 */     for (int di = 0; di < a.divs().size(); di++) {
/* 330 */       ADDiv div = a.divs().get(di);
/* 331 */       if (div.needSupplies()) {
/* 332 */         this.amountNeededMax.inc(div.army(), div.menTarget() * div.target().equipI(this.equip));
/* 333 */         this.amountNeeded.inc(div.army(), div.men() * div.target().equipI(this.equip));
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void transfer(WDIV div, WArmy old, WArmy current) {
/* 340 */     double divAmount = (div.menTarget() * div.target().equipI(this.equip));
/* 341 */     double armyAmount = this.amountNeededMax.get(old);
/* 342 */     int am = (int)(current().get(old) * divAmount / armyAmount);
/* 343 */     if (am > 0) {
/* 344 */       current().inc(old, -am);
/* 345 */       current().inc(current, am);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void hover(GBox b, WArmy a) {
/* 351 */     b.title(this.name);
/* 352 */     b.text(this.equip.resource.desc);
/*     */     
/* 354 */     b.sep();
/*     */     
/* 356 */     b.textL(Dic.¤¤Minimum);
/* 357 */     b.tab(6);
/* 358 */     b.add((SPRITE)GFORMAT.i(b.text(), minimumAmount(a)));
/* 359 */     b.NL();
/*     */     
/* 361 */     b.textL(Dic.¤¤Max);
/* 362 */     b.tab(6);
/* 363 */     b.add((SPRITE)GFORMAT.i(b.text(), targetAmount(a)));
/* 364 */     b.NL();
/*     */     
/* 366 */     b.textL(Dic.¤¤Stored);
/* 367 */     b.tab(6);
/* 368 */     b.add((SPRITE)GFORMAT.iofkInv(b.text(), current().get(a), targetAmount(a)));
/* 369 */     b.NL();
/*     */     
/* 371 */     b.textL(ADSupply.¤¤ConsumtionRate);
/* 372 */     b.tab(6);
/* 373 */     b.add((SPRITE)GFORMAT.f0(b.text(), -consumedPerDayCurrent(a)));
/* 374 */     b.NL();
/*     */     
/* 376 */     b.textL(ADSupply.¤¤days);
/* 377 */     b.tab(6);
/* 378 */     b.add((SPRITE)GFORMAT.f0(b.text(), daysStored(a)));
/* 379 */     b.NL();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\army\ADSupply$ADSupplyEquip.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */