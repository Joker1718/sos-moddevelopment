/*     */ package settlement.overlay;
/*     */ 
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.entity.EntityIterator;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.home.house.HomeInstance;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.GUTIL;
/*     */ import util.colors.GCOLOR;
/*     */ import util.rendering.RenderData;
/*     */ 
/*     */ final class Homeless extends Addable {
/*     */   private final EntityIterator.Humans iter;
/*     */   
/*     */   Homeless(String key, CharSequence name, CharSequence desc) {
/*  25 */     super((SPRITE)(UI.icons()).m.building, key, name, desc, true, false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  37 */     this.iter = new EntityIterator.Humans()
/*     */       {
/*     */         protected boolean processAndShouldBreakH(Humanoid a, int ie)
/*     */         {
/*  41 */           if ((a.indu().clas()).player && 
/*  42 */             (STATS.HOME()).GETTER.hasSearched.indu().get(a.indu()) == 1) {
/*  43 */             RoomInstance r = (RoomInstance)(STATS.WORK()).EMPLOYED.get(a.indu());
/*  44 */             if (r != null) {
/*  45 */               if (!GUTIL.flooder().hasBeenPushed(r.mX(), r.mY())) {
/*  46 */                 GUTIL.flooder().close(r.mX(), r.mY(), r.employees().employed());
/*  47 */                 GUTIL.flooder().setValue2(r.mX(), r.mY(), 1.0D);
/*     */               } else {
/*  49 */                 GUTIL.flooder().setValue2(r.mX(), r.mY(), GUTIL.flooder().getValue2(r.mX(), r.mY()));
/*     */               } 
/*     */             } else {
/*  52 */               GUTIL.flooder().close(a.tc().x(), a.tc().y(), 0.0D);
/*     */             } 
/*     */           } 
/*     */           
/*  56 */           return false;
/*     */         }
/*     */       };
/*     */     this.exclusive = true;
/*     */   }
/*     */   public void finishBelow() {
/*  62 */     GUTIL.flooder().done();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean render(Renderer r, RenderData.RenderIterator it) {
/*  67 */     return false;
/*     */   } public void initBelow(RenderData data) {
/*     */     GUTIL.flooder().init(this);
/*     */     this.iter.iterate();
/*     */   } public void renderBelow(Renderer r, RenderData.RenderIterator it) {
/*  72 */     Room room = (SETT.ROOMS()).map.get(it.tx(), it.ty());
/*     */     
/*  74 */     if (room != null) {
/*  75 */       int mx = room.mX(it.tx(), it.ty());
/*  76 */       int my = room.mY(it.tx(), it.ty());
/*  77 */       if (GUTIL.flooder().hasBeenPushed(mx, my) && GUTIL.flooder().getValue(mx, my) > 1.0F) {
/*  78 */         int tot = (int)GUTIL.flooder().getValue(mx, my);
/*  79 */         int home = (int)GUTIL.flooder().getValue2(mx, my);
/*  80 */         if (home == tot) {
/*  81 */           (GCOLOR.MAP()).BAD.bind();
/*     */         } else {
/*  83 */           (GCOLOR.MAP()).SOSO.bind();
/*     */         } 
/*  85 */       } else if (room.blueprint().employment() != null) {
/*  86 */         (GCOLOR.MAP()).OVERLAY_GOOD.bind();
/*     */       } else {
/*  88 */         HomeInstance h = (HomeInstance)(SETT.ROOMS()).HOME.getter.get(it.tx(), it.ty());
/*  89 */         if (h != null) {
/*  90 */           ColorImp.TMP.interpolate(COLOR.WHITE100, (GCOLOR.MAP()).BETTER, h.occupants() / h.occupantsMax());
/*  91 */           ColorImp.TMP.bind();
/*     */         } else {
/*  93 */           COLOR.WHITE10.bind();
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/*  98 */       (SPRITES.cons()).BIG.filled.render((SPRITE_RENDERER)r, 0, it.x(), it.y());
/*     */     }
/* 100 */     else if ((SETT.PATH().getAvailability(it.tx(), it.ty())).player > 0.0D) {
/* 101 */       COLOR.WHITE10.bind();
/* 102 */       (SPRITES.cons()).BIG.filled.render((SPRITE_RENDERER)r, 0, it.x(), it.y());
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\overlay\Homeless.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */