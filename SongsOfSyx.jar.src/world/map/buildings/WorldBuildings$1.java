/*    */ package world.map.buildings;
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
/* 49 */     WorldBuildings.this.village.save(file);
/*    */   }
/*    */ 
/*    */   
/*    */   public void load(FileGetter file) throws IOException {
/* 54 */     WorldBuildings.this.village.load(file);
/*    */   }
/*    */ 
/*    */   
/*    */   public void clear() {
/* 59 */     WorldBuildings.this.village.clear();
/*    */   }
/*    */ 
/*    */   
/*    */   public LIST<PLACABLE> makePlacers(ToolManager tm) {
/* 64 */     ArrayListGrower<PLACABLE> placers = new ArrayListGrower();
/* 65 */     Placer p = new Placer();
/* 66 */     placers.add(p);
/* 67 */     placers.add(p.getUndo());
/* 68 */     return (LIST<PLACABLE>)placers;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void generate(ACTION loadPrint) {
/* 74 */     loadPrint.exe();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void addDebugView() {
/* 80 */     WorldBuildings.this.debugVisible = true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\buildings\WorldBuildings$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */