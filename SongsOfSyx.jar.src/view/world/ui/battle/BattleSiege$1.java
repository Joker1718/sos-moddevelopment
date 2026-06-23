/*     */ package view.world.ui.battle;
/*     */ 
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Text;
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
/*     */ class null
/*     */   extends Battle.Butt
/*     */ {
/*     */   null(SPRITE $anonymous0, CharSequence $anonymous1) {
/*  78 */     super($anonymous0, $anonymous1);
/*     */   }
/*     */   public void hoverInfoGet(GUI_BOX text) {
/*  81 */     Text t = text.text();
/*  82 */     t.add(BattleSiege.¤¤autoD);
/*  83 */     t.insert(0, BattleSiege.this.g.victory ? Dic.¤¤Victory : (
/*  84 */         (BattleSiege.this.g.player.losses() >= BattleSiege.this.g.player.men()) ? BattleSiege.¤¤Annihilation : Dic.¤¤Defeat));
/*  85 */     t.insert(1, BattleSiege.this.g.player.losses());
/*  86 */     t.insert(2, BattleSiege.this.g.enemy.losses());
/*  87 */     text.add((SPRITE)t);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/*  93 */     super.render(r, ds, isActive, isSelected, isHovered);
/*  94 */     if (BattleSiege.this.g.victory) {
/*  95 */       OPACITY.O25.bind();
/*  96 */       COLOR.ORANGE100.render(r, (RECTANGLE)this.body, -4);
/*  97 */       OPACITY.unbind();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hover(COORDINATE mCoo) {
/* 104 */     if (super.hover(mCoo)) {
/* 105 */       BattleSiege.this.setCas(false, true);
/* 106 */       return true;
/*     */     } 
/* 108 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 113 */     BattleSiege.this.close.exe();
/* 114 */     BattleSiege.this.g.auto();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\battle\BattleSiege$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */