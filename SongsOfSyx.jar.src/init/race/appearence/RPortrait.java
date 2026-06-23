/*    */ package init.race.appearence;
/*    */ 
/*    */ import init.race.ExpandInit;
/*    */ import java.io.IOException;
/*    */ import settlement.stats.Induvidual;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.file.Json;
/*    */ 
/*    */ 
/*    */ public final class RPortrait
/*    */ {
/*    */   private final RPortraitFrame[] frames;
/*    */   public static final int P_WIDTH = 40;
/*    */   public static final int P_HEIGHT = 64;
/*    */   
/*    */   RPortrait(ExpandInit init, RColors colors, Json json) throws IOException {
/* 17 */     if (!json.has("FACE")) {
/* 18 */       this.frames = new RPortraitFrame[0];
/*    */       
/*    */       return;
/*    */     } 
/* 22 */     Json[] js = json.jsons("FACE");
/* 23 */     this.frames = new RPortraitFrame[js.length];
/* 24 */     for (int i = 0; i < this.frames.length; i++) {
/* 25 */       this.frames[i] = new RPortraitFrame(init.fm, colors, js[i], i);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void render(SPRITE_RENDERER r, int x1, int y1, Induvidual indu, int scale) {
/* 32 */     y1 += scale * 8; byte b; int i; RPortraitFrame[] arrayOfRPortraitFrame;
/* 33 */     for (i = (arrayOfRPortraitFrame = this.frames).length, b = 0; b < i; ) { RPortraitFrame f = arrayOfRPortraitFrame[b];
/* 34 */       f.render(r, x1, y1, indu, scale);
/*    */       b++; }
/*    */   
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\race\appearence\RPortrait.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */