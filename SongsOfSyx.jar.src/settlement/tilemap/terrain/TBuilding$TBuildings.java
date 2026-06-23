/*    */ package settlement.tilemap.terrain;
/*    */ 
/*    */ import init.paths.PATH;
/*    */ import init.paths.PATHS;
/*    */ import init.structure.STRUCTURES;
/*    */ import init.structure.Structure;
/*    */ import java.io.IOException;
/*    */ import java.util.HashMap;
/*    */ import snake2d.util.file.Json;
/*    */ import snake2d.util.sets.ArrayList;
/*    */ import snake2d.util.sets.LIST;
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
/*    */ public final class TBuildings
/*    */ {
/*    */   public final TBuilding MUD;
/*    */   private final ArrayList<TBuilding> all;
/*    */   
/*    */   TBuildings(Terrain terrain) throws IOException {
/* 71 */     PATHS.ResFolder f = STRUCTURES.path();
/* 72 */     HashMap<String, TBuilding> others = new HashMap<>();
/*    */     
/* 74 */     TBuilding[] all = new TBuilding[STRUCTURES.all().size()];
/*    */ 
/*    */     
/* 77 */     for (Structure s : STRUCTURES.all()) {
/* 78 */       Json d = new Json(f.init.gets(s.key));
/* 79 */       PATH sprite = f.sprite;
/* 80 */       TBuilding b = new TBuilding(s, terrain, d, sprite, others);
/* 81 */       all[s.index()] = b;
/*    */     } 
/*    */     
/* 84 */     this.MUD = all[STRUCTURES.mud().index()];
/* 85 */     this.all = new ArrayList((Object[])all);
/*    */   }
/*    */   
/*    */   public TBuilding get(Structure s) {
/* 89 */     return (TBuilding)this.all.get(s.index());
/*    */   }
/*    */   
/*    */   public LIST<TBuilding> all() {
/* 93 */     return (LIST<TBuilding>)this.all;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\terrain\TBuilding$TBuildings.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */