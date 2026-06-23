/*    */ package settlement.room.main.placement;
/*    */ 
/*    */ import game.GAME;
/*    */ import game.save.PROP;
/*    */ import init.structure.STRUCTURES;
/*    */ import init.structure.Structure;
/*    */ import settlement.job.JobBuildStructure;
/*    */ import settlement.main.SETT;
/*    */ import settlement.misc.job.SETT_JOB;
/*    */ import settlement.tilemap.terrain.TBuilding;
/*    */ import settlement.tilemap.terrain.Terrain;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import util.data.GETTER;
/*    */ 
/*    */ public final class UtilStructure extends GETTER.GETTER_IMP<TBuilding> {
/*    */   private final RoomPlacer p;
/* 17 */   private final PROP.PropGame saver = PROP.game("ROOM_CONSTRUCTION");
/*    */ 
/*    */ 
/*    */   
/*    */   int unroofed;
/*    */ 
/*    */   
/*    */   int tick;
/*    */ 
/*    */ 
/*    */   
/*    */   SETT_JOB getWallJob(int tx, int ty) {
/* 29 */     if ((SETT.TERRAIN()).CAVE.is(tx, ty))
/* 30 */       return (SETT_JOB)(SETT.JOBS()).clearss.caveFill; 
/* 31 */     return (SETT_JOB)((JobBuildStructure)(SETT.JOBS()).build_structure.get(((TBuilding)get()).structure.index())).wall;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   SETT_JOB getCeilingJob(int tx, int ty) {
/* 37 */     if ((SETT.TERRAIN()).MOUNTAIN.is(tx, ty))
/* 38 */       return null; 
/* 39 */     if (((TBuilding)get()).roof.is(tx, ty))
/* 40 */       return null; 
/* 41 */     if ((SETT.TERRAIN()).CAVE.is(tx, ty))
/* 42 */       return null; 
/* 43 */     return (SETT_JOB)((JobBuildStructure)(SETT.JOBS()).build_structure.get(((TBuilding)get()).structure.index())).ceiling;
/*    */   }
/*    */   
/*    */   void read() {
/* 47 */     String k = this.saver.chars("STRUCTURE");
/* 48 */     if (k != null && STRUCTURES.map().tryGet(k) != null) {
/* 49 */       set(((Structure)STRUCTURES.map().tryGet(k)).terrain());
/*    */     }
/*    */   }
/*    */   
/*    */   UtilStructure(RoomPlacer p) {
/* 54 */     this.unroofed = 0;
/* 55 */     this.tick = 0;
/*    */     this.p = p;
/*    */     set((SETT.TERRAIN()).BUILDINGS.MUD);
/*    */   } public int roofs() {
/* 59 */     if (GAME.updateI() != this.tick) {
/* 60 */       this.unroofed = 0;
/* 61 */       for (COORDINATE c : this.p.instance.body()) {
/* 62 */         if (!this.p.instance.is(c)) {
/*    */           continue;
/*    */         }
/* 65 */         if (getCeilingJob(c.x(), c.y()) != null) {
/* 66 */           this.unroofed++;
/*    */         }
/*    */       } 
/* 69 */       if (this.p.autoWalls.is()) {
/* 70 */         this.unroofed += this.p.door.getOpenings();
/*    */       }
/*    */     } 
/* 73 */     return this.unroofed;
/*    */   }
/*    */   
/*    */   public void set(TBuilding t) {
/* 77 */     super.set(t);
/* 78 */     this.saver.charsSet("STRUCTURE", t.structure.key);
/*    */   }
/*    */   public int walls() {
/* 81 */     if (!this.p.autoWalls.is())
/* 82 */       return 0; 
/* 83 */     return this.p.door.getWalls();
/*    */   }
/*    */   
/*    */   public int mountainWalls() {
/* 87 */     if (!this.p.autoWalls.is())
/* 88 */       return 0; 
/* 89 */     return this.p.door.getMountains();
/*    */   }
/*    */   
/*    */   public void set(int tx, int ty) {
/* 93 */     Terrain.TerrainTile t = SETT.TERRAIN().get(tx, ty);
/* 94 */     if (t instanceof TBuilding.BuildingComponent)
/* 95 */       set(((TBuilding.BuildingComponent)t).building()); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\placement\UtilStructure.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */