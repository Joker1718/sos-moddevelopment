/*    */ package util.spritecomposer;
/*    */ 
/*    */ import game.GAME;
/*    */ import java.io.IOException;
/*    */ import snake2d.CORE;
/*    */ import snake2d.TextureHolder;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class Initer
/*    */ {
/*    */   public abstract void createAssets() throws IOException;
/*    */   
/*    */   public TextureHolder get(String prefix, int WIDTH, int extraHeight) {
/*    */     try {
/* 21 */       TextureHolder t = read(prefix, WIDTH);
/* 22 */       if (t != null)
/* 23 */         return t; 
/* 24 */     } catch (IOException iOException) {}
/*    */ 
/*    */     
/* 27 */     Resources.delete(prefix);
/*    */     
/*    */     try {
/* 30 */       tryCreate(prefix, WIDTH, extraHeight);
/* 31 */     } catch (IOException e) {
/* 32 */       throw new RuntimeException(e);
/*    */     } 
/*    */     
/*    */     try {
/* 36 */       TextureHolder t = read(prefix, WIDTH);
/* 37 */       if (t == null)
/* 38 */         throw new RuntimeException("saved texture cache could not be loaded. Ensure the local file folder has access"); 
/* 39 */       return t;
/* 40 */     } catch (IOException e) {
/* 41 */       throw new RuntimeException(e);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   private void tryCreate(String prefix, int WIDTH, int extraHeight) throws IOException {
/* 47 */     GAME.Notify("creating new texture atlases " + prefix);
/* 48 */     Resources.init(prefix, WIDTH);
/* 49 */     createAssets();
/* 50 */     Resources.save(prefix, extraHeight);
/*    */   }
/*    */   
/*    */   private TextureHolder read(String prefix, int WIDTH) throws IOException {
/* 54 */     Resources.dispose();
/* 55 */     Result res = Resources.read(prefix, WIDTH);
/* 56 */     if (res == null)
/* 57 */       return null; 
/*    */     try {
/* 59 */       createAssets();
/* 60 */     } catch (IOException e) {
/* 61 */       CORE.disposeClient();
/* 62 */       res.diffuse.dispose();
/* 63 */       res.normal.dispose();
/* 64 */       throw e;
/*    */     } 
/* 66 */     return new TextureHolder(res.diffuse, res.normal, 0, (Optimizer.get(16)).startY, 16, 16);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\spritecomposer\Initer.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */