/*    */ package world.map.terrain;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ import snake2d.util.misc.ACTION;
/*    */ import snake2d.util.sets.ArrayListGrower;
/*    */ import snake2d.util.sets.LIST;
/*    */ import view.tool.PLACABLE;
/*    */ import view.tool.ToolManager;
/*    */ import world.WORLD;
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
/*    */   extends WORLD.WorldResourceManager
/*    */ {
/*    */   public void save(FilePutter file) {
/* 42 */     for (WorldTerrain.WorldTerrainResource r : WorldTerrain.resources) {
/* 43 */       r.save(file);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void load(FileGetter file) throws IOException {
/* 49 */     for (WorldTerrain.WorldTerrainResource r : WorldTerrain.resources) {
/* 50 */       r.load(file);
/*    */     }
/*    */   }
/*    */   
/*    */   public void clear() {
/* 55 */     for (WorldTerrain.WorldTerrainResource r : WorldTerrain.resources)
/* 56 */       r.clear(); 
/* 57 */     WORLD.MINIMAP().repaint();
/*    */   }
/*    */ 
/*    */   
/*    */   public LIST<PLACABLE> makePlacers(ToolManager tm) {
/* 62 */     ArrayListGrower<PLACABLE> res = new ArrayListGrower();
/* 63 */     for (WorldTerrain.WorldTerrainResource r : WorldTerrain.resources)
/* 64 */       res.add((Iterable)r.placers(tm)); 
/* 65 */     return (LIST<PLACABLE>)res;
/*    */   }
/*    */   
/*    */   public void validateInit(WORLD.WorldError error) {}
/*    */   
/*    */   public void generate(ACTION loadPrint) {}
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\terrain\WorldTerrain$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */