/*     */ package view.ui.div;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.div.Div;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.equip.EquipBattle;
/*     */ import settlement.stats.equip.EquipRange;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GMeter;
/*     */ import util.text.Dic;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends HOVERABLE.HoverableAbs
/*     */ {
/*     */   null(int $anonymous0, int $anonymous1) {
/* 121 */     super($anonymous0, $anonymous1);
/*     */   }
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/* 125 */     double def = 0.0D;
/* 126 */     double curr = 0.0D;
/* 127 */     double max = 0.0D;
/* 128 */     EquipRange rr = UIDivStats.best(UIDivStats.this.div);
/* 129 */     if (rr != null) {
/* 130 */       def = rr.projectile.range(0, rr.ref(0.0D, 0.0D));
/* 131 */       curr = rr.projectile.range(0, rr.ref(UIDivStats.this.div.equip((EquipBattle)rr), GAME.battle().boost(UIDivStats.this.div, rr.boostable)));
/* 132 */       for (EquipRange e : STATS.EQUIP().RANGED()) {
/* 133 */         max = Math.max(max, e.projectile.range(0, rr.ref(1.0D, rr.boostable.max(Div.class))));
/*     */       }
/* 135 */       def /= 64.0D;
/* 136 */       curr /= 64.0D;
/* 137 */       max /= 64.0D;
/*     */     } 
/* 139 */     GMeter.renderDelta(r, def / max, curr / max, this.body.x1(), body().x2(), this.body.y1(), this.body.cY(), GMeter.C_YELLOW);
/* 140 */     if (rr != null) {
/* 141 */       def = (GAME.battle()).power.range(rr, 0.0D);
/* 142 */       curr = (GAME.battle()).power.range(rr, rr.ref(UIDivStats.this.div.equip((EquipBattle)rr), GAME.battle().boost(UIDivStats.this.div, rr.boostable)));
/*     */     } 
/* 144 */     max = (GAME.battle()).power.bestRangedPower() + 1.0D;
/* 145 */     GMeter.renderDelta(r, def / max, curr / max, this.body.x1(), body().x2(), this.body.cY(), this.body.y2(), GMeter.C_ORANGE);
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 150 */     GBox box = (GBox)text;
/* 151 */     box.title(Dic.¤¤Ammunition);
/* 152 */     EquipRange b = UIDivStats.best(UIDivStats.this.div);
/*     */     
/* 154 */     if (b != null)
/*     */     {
/* 156 */       b.projectile.hover((GUI_BOX)box, null, b.ref(UIDivStats.this.div.equip((EquipBattle)b), GAME.battle().boost(UIDivStats.this.div, b.boostable)), 0);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\div\UIDivStats$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */