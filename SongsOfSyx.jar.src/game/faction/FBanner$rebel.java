/*     */ package game.faction;
/*     */ 
/*     */ import init.sprite.SPRITES;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class rebel
/*     */ {
/* 242 */   public static final SPRITE MEDIUM = (SPRITE)new SPRITE.Imp(24)
/*     */     {
/*     */       
/*     */       public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */       {
/* 247 */         (SPRITES.icons()).m.circle_frame.render(r, X1, Y1);
/* 248 */         (GCOLOR.MAP()).F_REBEL.bind();
/* 249 */         (SPRITES.icons()).m.circle_inner.render(r, X1, Y1);
/* 250 */         COLOR.unbind();
/*     */       }
/*     */     };
/*     */ 
/*     */   
/* 255 */   public static final SPRITE BIG = (SPRITE)new SPRITE.Imp(32)
/*     */     {
/*     */       public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */       {
/* 259 */         (GCOLOR.MAP()).F_REBEL.bind();
/* 260 */         (SPRITES.icons()).l.banners[0].render(r, X1, X2, Y1, Y2);
/* 261 */         COLOR.WHITE30.bind();
/* 262 */         (SPRITES.icons()).l.bannerPole.render(r, X1, X2, Y1, Y2);
/* 263 */         COLOR.unbind();
/*     */       }
/*     */     };
/*     */ 
/*     */   
/* 268 */   public static final SPRITE HUGE = (SPRITE)new SPRITE.Imp(64)
/*     */     {
/*     */       public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */       {
/* 272 */         (GCOLOR.MAP()).F_REBEL.bind();
/* 273 */         (SPRITES.icons()).l.banners[0].render(r, X1, X2, Y1, Y2);
/* 274 */         COLOR.WHITE30.bind();
/* 275 */         (SPRITES.icons()).l.bannerPole.render(r, X1, X2, Y1, Y2);
/* 276 */         COLOR.unbind();
/*     */       }
/*     */     };
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\FBanner$rebel.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */