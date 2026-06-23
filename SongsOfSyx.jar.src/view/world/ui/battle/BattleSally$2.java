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
/*     */ class null
/*     */   extends Battle.Butt
/*     */ {
/*     */   null(SPRITE $anonymous0, CharSequence $anonymous1) {
/*  64 */     super($anonymous0, $anonymous1);
/*     */   }
/*     */   public void hoverInfoGet(GUI_BOX text) {
/*  67 */     Text t = text.text();
/*  68 */     t.add(BattleSally.¤¤autoD);
/*  69 */     t.insert(0, BattleSally.this.g.victory ? Dic.¤¤Victory : (
/*  70 */         (BattleSally.this.g.player.losses() >= BattleSally.this.g.player.men()) ? BattleSally.¤¤Annihilation : Dic.¤¤Defeat));
/*  71 */     t.insert(1, BattleSally.this.g.player.losses());
/*  72 */     t.insert(2, BattleSally.this.g.enemy.losses());
/*  73 */     text.add((SPRITE)t);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/*  79 */     super.render(r, ds, isActive, isSelected, isHovered);
/*  80 */     if (BattleSally.this.g.victory) {
/*  81 */       OPACITY.O25.bind();
/*  82 */       COLOR.ORANGE100.render(r, (RECTANGLE)this.body, -4);
/*  83 */       OPACITY.unbind();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hover(COORDINATE mCoo) {
/*  90 */     if (super.hover(mCoo)) {
/*  91 */       BattleSally.this.setCas(false, true);
/*  92 */       return true;
/*     */     } 
/*  94 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clickA() {
/*  99 */     BattleSally.this.close.exe();
/* 100 */     BattleSally.this.g.auto();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\battle\BattleSally$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */