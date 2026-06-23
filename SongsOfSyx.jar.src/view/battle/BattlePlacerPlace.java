/*     */ package view.battle;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.audio.AUDIO;
/*     */ import game.audio.SoundRace;
/*     */ import game.battle.div.Div;
/*     */ import init.sprite.SPRITES;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GBox;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import view.main.VIEW;
/*     */ import view.subview.GameWindow;
/*     */ 
/*     */ public final class BattlePlacerPlace
/*     */   extends BattlePlacer.Mode {
/*     */   private final GameWindow w;
/*     */   final DivSelection s;
/*     */   private final BattlePlacer.Action a;
/*     */   private boolean sounded = false;
/*  25 */   private final SoundRace sound = AUDIO.race("UP_PLACE_DIV");
/*     */   
/*     */   public BattlePlacerPlace(GameWindow w, DivSelection s, BattlePlacer.Action a) {
/*  28 */     this.w = w;
/*  29 */     this.s = s;
/*  30 */     this.a = a;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void update(boolean hovered) {
/*  36 */     if (!hovered) {
/*     */       return;
/*     */     }
/*  39 */     if (!this.a.clicked)
/*     */     {
/*     */       
/*  42 */       this.sounded = false;
/*     */     }
/*     */     
/*  45 */     if (this.a.clickReleased) {
/*     */ 
/*     */       
/*  48 */       (GAME.ARMIES()).placer.deploy(this.s.selection(), this.a.start.x(), this.w.pixel().x(), this.a.start.y(), this.w.pixel().y());
/*  49 */       if (VIEW.b().state() != null && VIEW.b().state().deploying())
/*     */       {
/*  51 */         GAME.ARMIES().initAndTeleport(this.s.selection());
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void render(Renderer r, ShadowBatch shadowBatch, RenderData data, double ds) {
/*  62 */     if (!this.a.clicked) {
/*  63 */       int px = this.w.pixel().x();
/*  64 */       int py = this.w.pixel().y();
/*  65 */       if (this.s.selection().size() == 0 || (GAME.ARMIES()).placer.isBlocked(px, py, 64, ((Div)this.s.selection().get(0)).army())) {
/*  66 */         (GCOLOR.MAP()).BAD.bind();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       }
/*     */       else {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 110 */         (GCOLOR.MAP()).BATTLE_OK.bind();
/*     */       } 
/*     */       
/* 113 */       (SPRITES.cons()).BIG.dots.renderCentered((SPRITE_RENDERER)r, 0, px - data.offX1(), py - data.offY1());
/* 114 */       VIEW.mouse().setReplacement((SPRITE)(SPRITES.icons()).m.place_line);
/*     */       
/* 116 */       COLOR.unbind();
/*     */       return;
/*     */     } 
/* 119 */     if ((GAME.ARMIES()).placer.render((SPRITE_RENDERER)r, this.s.selection(), this.a.start.x(), this.w.pixel().x(), this.a.start.y(), this.w.pixel().y(), data) && 
/* 120 */       !this.sounded) {
/* 121 */       this.sounded = true;
/* 122 */       this.sound.play(true);
/*     */     } 
/*     */   }
/*     */   
/*     */   void hoverTimer(GBox text) {}
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\battle\BattlePlacerPlace.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */