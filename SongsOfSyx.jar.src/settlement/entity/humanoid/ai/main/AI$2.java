/*    */ package settlement.entity.humanoid.ai.main;
/*    */ 
/*    */ import game.save.Savable;
/*    */ import java.io.IOException;
/*    */ import java.util.Arrays;
/*    */ import snake2d.util.file.Alloc;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends Savable
/*    */ {
/*    */   null(String $anonymous0) {
/* 71 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   public void save(FilePutter file) {
/* 75 */     file.i(AI.this.all.size());
/* 76 */     for (AI.AIElement e : AI.this.all) {
/* 77 */       file.chars(e.key);
/*    */     }
/*    */   }
/*    */   
/*    */   public void load(FileGetter file) throws IOException {
/* 82 */     int am = file.i();
/* 83 */     AI.this.loadOrder = Alloc.ii(am);
/* 84 */     Arrays.fill(AI.this.loadOrder, -1);
/* 85 */     for (int i = 0; i < am; i++) {
/* 86 */       String k = file.chars();
/* 87 */       if (AI.this.map.containsKey(k))
/* 88 */         AI.this.loadOrder[i] = ((AI.AIElement)AI.this.map.get(k)).index; 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\main\AI$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */