/*     */ package settlement.room.main.construction;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import settlement.job.Job;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.finders.SFinderFindable;
/*     */ import settlement.room.main.ROOMS;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprint;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.tilemap.terrain.TBuilding;
/*     */ import settlement.tilemap.terrain.Terrain;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.sets.ArrayListResize;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import view.sett.IDebugPanelSett;
/*     */ import view.sett.ui.room.UIRoomModule;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.PLACER_TYPE;
/*     */ import view.tool.PlacableMulti;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class ConstructionBlueprint
/*     */   extends RoomBlueprint
/*     */ {
/*  34 */   final ConstructionHoverer hoverer = new ConstructionHoverer();
/*  35 */   ArrayListResize<ConstructionInstance> all = new ArrayListResize(256);
/*     */   private Rec rec;
/*     */   
/*  38 */   public ConstructionBlueprint(ROOMS r) { super("_CONSTRUCTION");
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
/* 147 */     this.rec = new Rec(); PlacableMulti placableMulti = new PlacableMulti("Finish room") {
/*     */         public void place(int tx, int ty, AREA a, PLACER_TYPE t) { if ((SETT.ROOMS()).map.is(tx, ty)) { ConstructionBlueprint.this.construct(tx, ty); } else { Job j = (Job)(SETT.JOBS()).getter.get(tx, ty); if (j != null) { Terrain.TerrainTile tt = j.becomes(tx, ty); (SETT.JOBS()).clearer.set(tx, ty); tt.placeFixed(tx, ty); }  }  } public CharSequence isPlacable(int tx, int ty, AREA a, PLACER_TYPE t) { return (ConstructionBlueprint.this.is(tx, ty) || (SETT.JOBS()).getter.get(tx, ty) != null) ? null : ""; } public boolean expandsTo(int fromX, int fromY, int toX, int toY) { if (ConstructionBlueprint.this.is(fromX, fromY)) { if (ConstructionBlueprint.this.is(toX, toY)) return true;  if ((SETT.JOBS()).getter.get(toX, toY) != null) return true;  }  return false; }
/* 149 */       }; IDebugPanelSett.add((PLACABLE)placableMulti); } public void construct(int tx, int ty) { ConstructionInstance r = get(tx, ty);
/* 150 */     if (r == null)
/*     */       return; 
/* 152 */     if (r.mX() != tx || r.mY() != ty)
/*     */       return; 
/* 154 */     this.rec.set(r.body());
/* 155 */     for (COORDINATE c : this.rec) {
/*     */       
/* 157 */       if (!r.is(c))
/*     */         continue; 
/* 159 */       r.jobClear(c.x(), c.y());
/* 160 */       if (r.blueprint.removeFertility())
/* 161 */         (SETT.GRASS()).current.set(c.x(), c.y(), 0.0D); 
/* 162 */       if (!(SETT.TERRAIN()).CAVE.is(c) && r.structureI != -1 && !((TBuilding)(SETT.TERRAIN()).BUILDINGS.all().get(r.structureI)).roof.is(c))
/* 163 */         ((TBuilding)(SETT.TERRAIN()).BUILDINGS.all().get(r.structureI)).roof.placeFixed(c.x(), c.y()); 
/* 164 */       if (!((Terrain.TerrainTile)SETT.TERRAIN().get(c)).clearing().isStructure() && r.blueprint.removeTerrain(c.x(), c.y())) {
/* 165 */         (SETT.TERRAIN()).NADA.placeFixed(c.x(), c.y());
/*     */       }
/* 167 */       r.blueprint.putFloor(c.x(), c.y(), r.upgrade(), (AREA)r);
/*     */     } 
/* 169 */     r.finish(); }
/*     */ 
/*     */   
/*     */   protected void update(double ds) {}
/*     */   
/*     */   public SFinderFindable service(int tx, int ty) {
/*     */     return null;
/*     */   }
/*     */   
/*     */   public ConstructionInstance create(TmpArea area, ConstructionInit init) {
/*     */     ConstructionInstance ins = new ConstructionInstance(this, area, init);
/*     */     if ((SETT.ROOMS()).map.get(ins.mX(), ins.mY()) == ins)
/*     */       this.all.add(ins); 
/*     */     return ins;
/*     */   }
/*     */   
/*     */   void remove(ConstructionInstance ins) {
/*     */     this.all.remove(ins);
/*     */   }
/*     */   
/*     */   public ConstructionInstance get(int tx, int ty) {
/*     */     Room r = (SETT.ROOMS()).map.get(tx, ty);
/*     */     if (r != null && r instanceof ConstructionInstance)
/*     */       return (ConstructionInstance)r; 
/*     */     return null;
/*     */   }
/*     */   
/*     */   public COLOR miniC(int tx, int ty) {
/*     */     return (get(tx, ty)).blueprint.miniColor(tx, ty);
/*     */   }
/*     */   
/*     */   public COLOR miniCPimped(ColorImp origional, int tx, int ty, boolean northern, boolean southern) {
/*     */     return (get(tx, ty)).blueprint.miniColorPimped(origional, tx, ty, northern, southern);
/*     */   }
/*     */   
/*     */   protected void save(FilePutter saveFile) {
/*     */     saveFile.object(this.all);
/*     */   }
/*     */   
/*     */   protected void load(FileGetter saveFile) throws IOException {
/*     */     this.all.clear();
/*     */     Object a = saveFile.object(true);
/*     */     if (a != null) {
/*     */       ArrayListResize<ConstructionInstance> li = (ArrayListResize<ConstructionInstance>)a;
/*     */       for (ConstructionInstance i : li) {
/*     */         if (!i.constructing)
/*     */           this.all.add(i); 
/*     */       } 
/*     */     } else {
/*     */       clear();
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void clear() {
/*     */     this.all.clear();
/*     */   }
/*     */   
/*     */   public void appendView(LISTE<UIRoomModule> mm) {
/*     */     mm.add(this.hoverer);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\construction\ConstructionBlueprint.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */