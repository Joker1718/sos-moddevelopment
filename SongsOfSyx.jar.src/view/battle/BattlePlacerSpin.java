/*     */ package view.battle;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.div.Div;
/*     */ import game.battle.formation.DivFormationImp;
/*     */ import game.battle.thread.order.BattleOrderTask;
/*     */ import game.battle.util.Copyable;
/*     */ import game.battle.util.DIV_SPEC;
/*     */ import init.sprite.SPRITES;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.VectorImp;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GBox;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import view.main.VIEW;
/*     */ import view.subview.GameWindow;
/*     */ 
/*     */ final class BattlePlacerSpin
/*     */   extends BattlePlacer.Mode
/*     */ {
/*     */   private final GameWindow w;
/*     */   private final DivSelection s;
/*  27 */   private final DivFormationImp form = new DivFormationImp();
/*     */   
/*     */   private final BattlePlacer.Action a;
/*     */   
/*     */   private final BattleOrderTask task;
/*     */   private double cx;
/*     */   private double cy;
/*     */   private final VectorImp vec;
/*     */   
/*     */   public BattlePlacerSpin(GameWindow w, DivSelection s, BattlePlacer.Action a) {
/*  37 */     this.task = new BattleOrderTask();
/*     */     
/*  39 */     this.vec = new VectorImp();
/*     */     this.w = w;
/*     */     this.s = s;
/*     */     this.a = a;
/*     */   } void update(boolean hovered) {
/*  44 */     this.cx = 0.0D;
/*  45 */     this.cy = 0.0D;
/*  46 */     for (Div d : this.s.selection()) {
/*  47 */       (d.order()).dest.get((Copyable)this.form);
/*  48 */       this.cx += this.form.start().x();
/*  49 */       this.cy += this.form.start().y();
/*     */     } 
/*  51 */     this.cx /= this.s.selection().size();
/*  52 */     this.cy /= this.s.selection().size();
/*     */     
/*  54 */     if (!hovered) {
/*     */       return;
/*     */     }
/*     */     
/*  58 */     if (this.a.clickReleased) {
/*     */       
/*  60 */       for (Div d : this.s.selection()) {
/*  61 */         DivFormationImp f = getFor(d);
/*  62 */         if (f != null) {
/*  63 */           (d.order()).dest.set((Copyable)f);
/*  64 */           this.task.move(d);
/*  65 */           (d.order()).task.set((Copyable)this.task);
/*     */         } 
/*     */       } 
/*  68 */       if (VIEW.b().state() != null && VIEW.b().state().deploying())
/*     */       {
/*  70 */         GAME.ARMIES().initAndTeleport(this.s.selection());
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private DivFormationImp getFor(Div d) {
/*  79 */     (d.order()).dest.get((Copyable)this.form);
/*     */     
/*  81 */     double newAngle = 0.0D;
/*     */     
/*  83 */     double destDX = (this.w.pixel().x() - this.a.start.x());
/*  84 */     destDX /= (100 << this.w.zoomout());
/*  85 */     destDX %= 6.283185307179586D;
/*  86 */     newAngle = destDX;
/*     */ 
/*     */     
/*  89 */     double dist = this.vec.set(this.cx, this.cy, this.form.start().x(), this.form.start().y());
/*     */     
/*  91 */     this.vec.rotateRad(newAngle);
/*     */     
/*  93 */     double x1 = this.a.start.x() + this.vec.nX() * dist;
/*  94 */     double y1 = this.a.start.y() + this.vec.nY() * dist;
/*     */     
/*  96 */     this.vec.set(this.form.dx(), this.form.dy());
/*  97 */     this.vec.rotateRad(newAngle);
/*     */     
/*  99 */     return (GAME.ARMIES()).placer.deployer.deploy((DIV_SPEC)d.info, d.menNrOf(), (d.settings()).formation, (int)x1, (int)y1, this.vec.nX(), this.vec.nY(), this.form.width(), d.army());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void render(Renderer r, ShadowBatch shadowBatch, RenderData data, double ds) {
/* 106 */     VIEW.mouse().setReplacement((SPRITE)(SPRITES.icons()).m.rotate);
/*     */ 
/*     */     
/* 109 */     if (this.a.clicked) {
/* 110 */       int x = this.w.pixel().x();
/* 111 */       int y = this.w.pixel().y();
/*     */       
/* 113 */       if ((GAME.ARMIES()).placer.isBlocked(x, y, 64, GAME.ARMIES().player())) {
/* 114 */         (GCOLOR.MAP()).BAD.bind();
/*     */       } else {
/* 116 */         (GCOLOR.MAP()).BATTLE_OK.bind();
/* 117 */       }  (SPRITES.cons()).BIG.dots.renderCentered((SPRITE_RENDERER)r, 0, x - data.offX1(), y - data.offY1());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 123 */       COLOR.unbind();
/* 124 */       for (Div d : this.s.selection())
/* 125 */         (GAME.ARMIES()).placer.render((SPRITE_RENDERER)r, getFor(d), data); 
/*     */       return;
/*     */     } 
/*     */   }
/*     */   
/*     */   void hoverTimer(GBox text) {}
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\battle\BattlePlacerSpin.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */