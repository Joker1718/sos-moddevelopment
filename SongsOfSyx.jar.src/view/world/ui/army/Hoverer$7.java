/*     */ package view.world.ui.army;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.raiding.RaiderPortrait;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
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
/*     */ class null
/*     */   extends RENDEROBJ.RenderImp
/*     */ {
/*     */   null(int $anonymous0) {
/* 103 */     super($anonymous0);
/*     */   }
/*     */   
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/* 107 */     if (((WArmy)Hoverer.this.a.get()).faction() != null) {
/* 108 */       (((WArmy)Hoverer.this.a.get()).faction().banner()).HUGE.render(r, this.body.x1(), this.body.y1());
/*     */     }
/* 110 */     else if ((GAME.raiders()).current.army() == Hoverer.this.a.get()) {
/* 111 */       RaiderPortrait.render(r, this.body.x1() - 8, this.body.y1() - 10, 2, ((GAME.raiders()).current.current()).indu, false);
/*     */     } else {
/* 113 */       (UI.icons()).l.rebel.huge.render(r, this.body.x1(), this.body.y1());
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\army\Hoverer$7.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */