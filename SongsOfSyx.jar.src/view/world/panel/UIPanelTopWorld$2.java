/*     */ package view.world.panel;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.faction.FACTIONS;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.text.Dic;
/*     */ import view.ui.top.UIPanelTopButtL;
/*     */ import view.world.WorldView;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ import world.region.pop.RDRace;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends UIPanelTopButtL
/*     */ {
/*     */   private final GAME.Cache cache;
/*     */   private double worst;
/*     */   private double worstTarget;
/*     */   
/*     */   null(SPRITE $anonymous0) {
/* 128 */     super($anonymous0);
/*     */     
/* 130 */     this.cache = new GAME.Cache(60);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected double valueNext() {
/* 136 */     cache();
/* 137 */     return this.worstTarget;
/*     */   }
/*     */ 
/*     */   
/*     */   protected double value() {
/* 142 */     cache();
/* 143 */     return this.worst;
/*     */   }
/*     */   
/*     */   private void cache() {
/* 147 */     if (!this.cache.shouldAndReset())
/*     */       return; 
/* 149 */     this.worst = 1.0D;
/* 150 */     this.worstTarget = 1.0D;
/* 151 */     for (int i = 0; i < FACTIONS.player().realm().regions(); i++) {
/* 152 */       Region r = FACTIONS.player().realm().region(i);
/* 153 */       if (!r.capitol()) {
/* 154 */         for (RDRace ra : (RD.RACES()).all) {
/* 155 */           this.worst = Math.min(ra.loyalty.get(r), this.worst);
/* 156 */           this.worstTarget = Math.min(this.worstTarget, ra.loyaltyTarget(r));
/*     */         } 
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isActive() {
/* 165 */     return (FACTIONS.player().realm().regions() > 1);
/*     */   }
/*     */ 
/*     */   
/*     */   protected int getNumber() {
/* 170 */     return FACTIONS.player().realm().regions() - 1;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void renAction() {
/* 175 */     selectedSet(w.panels.added(w.UI.regions.playerList));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 180 */     if (w.panels.added(w.UI.regions.playerList))
/* 181 */       w.panels.remove(w.UI.regions.playerList); 
/* 182 */     w.panels.add(w.UI.regions.playerList, true);
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 187 */     GBox b = (GBox)text;
/* 188 */     b.title(Dic.¤¤Realm);
/* 189 */     b.text(Dic.¤¤RegionDesc);
/*     */     
/* 191 */     super.hoverInfoGet(text);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\world\panel\UIPanelTopWorld$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */