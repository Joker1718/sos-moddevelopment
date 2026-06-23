/*     */ package view.ui.top;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.faction.FACTIONS;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sets.Bitmap1D;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import view.main.VIEW;
/*     */ import world.WORLD;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends UINotifications.UINotification
/*     */ {
/*     */   final Bitmap1D has;
/*     */   int am;
/*     */   int ri;
/*     */   int k;
/*     */   private final GAME.Cache cache;
/*     */   
/*     */   null(SPRITE $anonymous0, COLOR $anonymous1, CharSequence $anonymous2, CharSequence $anonymous3) {
/* 448 */     super($anonymous0, $anonymous1, $anonymous2, $anonymous3);
/*     */     
/* 450 */     this.has = new Bitmap1D(1023, false);
/*     */ 
/*     */     
/* 453 */     this.am = 0;
/* 454 */     this.ri = 0;
/* 455 */     this.k = 0;
/* 456 */     this.cache = new GAME.Cache(4);
/*     */   }
/*     */   
/*     */   public int get() {
/* 460 */     if (!this.cache.shouldAndReset())
/* 461 */       return this.am; 
/* 462 */     Region reg = WORLD.REGIONS().getByIndex(this.ri);
/* 463 */     if (this.has.get(this.ri))
/* 464 */       this.am--; 
/* 465 */     if (reg != null && reg.active() && !reg.capitol() && reg.faction() == FACTIONS.player())
/*     */     {
/* 467 */       if (RD.PROBLEM().problem(reg) != null) {
/* 468 */         this.am++;
/* 469 */         this.has.set(this.ri, true);
/*     */       } 
/*     */     }
/*     */     
/* 473 */     this.ri++;
/* 474 */     this.ri %= 1023;
/* 475 */     return this.am;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 481 */     for (int ri = 0; ri < FACTIONS.player().realm().regions(); ri++) {
/* 482 */       this.k %= FACTIONS.player().realm().regions();
/* 483 */       Region reg = FACTIONS.player().realm().region(this.k);
/* 484 */       this.k++;
/* 485 */       if (!reg.capitol())
/*     */       {
/* 487 */         if (RD.PROBLEM().problem(reg) != null) {
/* 488 */           VIEW.world().activate();
/* 489 */           (VIEW.world()).UI.regions.open(reg);
/* 490 */           (VIEW.world()).window.centererTile.set(reg.cx(), reg.cy());
/*     */           return;
/*     */         } 
/*     */       }
/*     */     } 
/* 495 */     this.am = 0;
/* 496 */     this.has.setAll(false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 502 */     super.hoverInfoGet(text);
/* 503 */     GBox b = (GBox)text;
/* 504 */     int aa = 0;
/* 505 */     for (int ri = 0; ri < FACTIONS.player().realm().regions(); ri++) {
/* 506 */       FACTIONS.player().realm().regions();
/* 507 */       Region reg = FACTIONS.player().realm().region(ri);
/* 508 */       if (!reg.capitol()) {
/*     */         
/* 510 */         CharSequence p = RD.PROBLEM().problem(reg);
/* 511 */         if (p != null) {
/* 512 */           b.textLL((CharSequence)reg.info.name());
/* 513 */           b.NL();
/* 514 */           b.error(p);
/* 515 */           b.NL(8);
/* 516 */           if (aa++ > 8)
/*     */             break; 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\top\UINotifications$9.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */