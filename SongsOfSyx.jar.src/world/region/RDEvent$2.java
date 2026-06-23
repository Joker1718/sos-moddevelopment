/*    */ package world.region;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ import snake2d.util.file.SAVABLE;
/*    */ import world.WORLD;
/*    */ import world.map.regions.Region;
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
/*    */   implements SAVABLE
/*    */ {
/*    */   public void save(FilePutter file) {}
/*    */   
/*    */   public void load(FileGetter file) throws IOException {
/* 52 */     RDEvent.this.am = 0;
/* 53 */     for (Region reg : WORLD.REGIONS().all()) {
/* 54 */       RDEvent.this.am += RDEvent.this.ii.get(reg);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void clear() {
/* 60 */     RDEvent.this.am = 0;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\region\RDEvent$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */