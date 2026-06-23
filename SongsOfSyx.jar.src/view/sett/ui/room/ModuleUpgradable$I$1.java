/*     */ package view.sett.ui.room;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.FResources;
/*     */ import java.util.Arrays;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.info.GFORMAT;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends UIRoomBulkApplier
/*     */ {
/*     */   private final int[] res;
/*     */   
/*     */   null(CharSequence $anonymous0) {
/*  82 */     super($anonymous0);
/*     */     
/*  84 */     this.res = Alloc.ii(16);
/*     */   }
/*     */   
/*     */   protected void apply(RoomInstance ii) {
/*     */     int i;
/*  89 */     if (ii.upgrade() >= ModuleUpgradable.I.this.blueprint.upgrades().max() || !ii.blueprintI().upgrades().requires(ii.upgrade() + 1).passes(FACTIONS.player()))
/*     */       return; 
/*  91 */     boolean okk = true; int ri;
/*  92 */     for (ri = 0; ri < ModuleUpgradable.I.this.blueprint.constructor().resources(); ri++) {
/*  93 */       int am = ii.resAmount(ri, ii.upgrade() + 1) - ii.resAmount(ri, ii.upgrade());
/*  94 */       i = okk & ((((SETT.ROOMS()).STOCKPILE.tally()).amountReservable.get(ModuleUpgradable.I.this.blueprint.constructor().resource(ri)) >= am) ? 1 : 0);
/*     */     } 
/*     */     
/*  97 */     if (i != 0) {
/*  98 */       for (ri = 0; ri < ModuleUpgradable.I.this.blueprint.constructor().resources(); ri++) {
/*  99 */         int am = ii.resAmount(ri, ii.upgrade() + 1) - ii.resAmount(ri, ii.upgrade());
/* 100 */         ModuleUpgradable.I.this.blueprint.constructor().resource(ri).remove(am, FResources.RTYPE.CONSTRUCTION);
/*     */       } 
/* 102 */       ii.upgradeSet(ii.upgrade() + 1);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void hover(GBox b) {
/* 108 */     b.title((ModuleUpgradable.I.access$0(ModuleUpgradable.I.this)).¤¤UPGRADE_ALL);
/* 109 */     b.text((ModuleUpgradable.I.access$0(ModuleUpgradable.I.this)).¤¤UPGRADE_ALL_DESC);
/* 110 */     b.NL(8);
/*     */     
/* 112 */     Arrays.fill(this.res, 0);
/*     */     
/* 114 */     int ok = 0;
/* 115 */     for (int i = 0; i < ModuleUpgradable.I.this.blueprint.instancesSize(); i++) {
/* 116 */       RoomInstance ii = ModuleUpgradable.I.this.blueprint.getInstance(i);
/*     */       
/* 118 */       if (ii.upgrade() < ModuleUpgradable.I.this.blueprint.upgrades().max() && ii.blueprintI().upgrades().requires(ii.upgrade() + 1).passes(FACTIONS.player())) {
/* 119 */         boolean okk = true; int j;
/* 120 */         for (j = 0; j < ModuleUpgradable.I.this.blueprint.constructor().resources(); j++) {
/* 121 */           int am = ii.resAmount(j, ii.upgrade() + 1) - ii.resAmount(j, ii.upgrade());
/* 122 */           if (((SETT.ROOMS()).STOCKPILE.tally()).amountReservable.get(ModuleUpgradable.I.this.blueprint.constructor().resource(j)) < this.res[j] + am)
/*     */           {
/*     */             
/* 125 */             okk = false;
/*     */           }
/*     */         } 
/*     */         
/* 129 */         if (okk) {
/* 130 */           ok++;
/* 131 */           for (j = 0; j < ModuleUpgradable.I.this.blueprint.constructor().resources(); j++) {
/* 132 */             int am = ii.resAmount(j, ii.upgrade() + 1) - ii.resAmount(j, ii.upgrade());
/* 133 */             this.res[j] = this.res[j] + am;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 140 */     for (int ri = 0; ri < ModuleUpgradable.I.this.blueprint.constructor().resources(); ri++) {
/* 141 */       if (this.res[ri] > 0) {
/* 142 */         b.add((SPRITE)ModuleUpgradable.I.this.blueprint.constructor().resource(ri).icon());
/* 143 */         b.add((SPRITE)GFORMAT.iIncr(b.text(), -this.res[ri]));
/* 144 */         b.NL();
/*     */       } 
/*     */     } 
/*     */     
/* 148 */     b.NL(8);
/*     */     
/* 150 */     b.textL((ModuleUpgradable.I.access$0(ModuleUpgradable.I.this)).¤¤UPGRADABLE);
/* 151 */     b.add((SPRITE)GFORMAT.iofkInv(b.text(), ok, ModuleUpgradable.I.this.blueprint.instancesSize()));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\ModuleUpgradable$I$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */