/*     */ package settlement.room.home.house;
/*     */ 
/*     */ import init.type.HGROUP;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.finders.SFinderFindable;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.category.RoomCategorySub;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import settlement.thing.pointlight.LOS;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.map.MAP_OBJECT;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import view.sett.ui.room.UIRoomModule;
/*     */ 
/*     */ 
/*     */ public class ROOM_HOME
/*     */   extends RoomBlueprintImp
/*     */ {
/*  25 */   private final int[] total = Alloc.ii(HGROUP.all().size());
/*  26 */   private final int[] used = Alloc.ii(HGROUP.all().size());
/*     */   
/*     */   private int totalT;
/*     */   
/*     */   private int usedT;
/*     */   final HomeContructor constructor;
/*  32 */   public final OddHome odd = new OddHome(); public MAP_OBJECT<HomeInstance> getter; public MAP_OBJECT<HomeInstance> service;
/*     */   private final LOS los;
/*     */   
/*  35 */   public ROOM_HOME(RoomInitData init, RoomCategorySub cat) throws IOException { super(init, 0, "_HOME", cat);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 121 */     this.getter = new MAP_OBJECT<HomeInstance>()
/*     */       {
/*     */         public HomeInstance get(int tx, int ty)
/*     */         {
/* 125 */           if ((SETT.ROOMS()).map.blueprint.get(tx, ty) == ROOM_HOME.this) {
/* 126 */             return (HomeInstance)(SETT.ROOMS()).map.get(tx, ty);
/*     */           }
/* 128 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public HomeInstance get(int tile) {
/* 133 */           if ((SETT.ROOMS()).map.blueprint.get(tile) == ROOM_HOME.this) {
/* 134 */             return (HomeInstance)(SETT.ROOMS()).map.get(tile);
/*     */           }
/* 136 */           return null;
/*     */         }
/*     */       };
/*     */     
/* 140 */     this.service = new MAP_OBJECT<HomeInstance>()
/*     */       {
/*     */         public HomeInstance get(int tx, int ty)
/*     */         {
/* 144 */           if ((SETT.ROOMS()).map.blueprint.get(tx, ty) == ROOM_HOME.this) {
/* 145 */             HomeInstance h = (HomeInstance)(SETT.ROOMS()).map.get(tx, ty);
/* 146 */             if (tx == h.serviceX() && ty == h.serviceY())
/* 147 */               return h; 
/*     */           } 
/* 149 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public HomeInstance get(int tile) {
/* 154 */           return get(tile % SETT.TWIDTH, tile / SETT.TWIDTH);
/*     */         }
/*     */       };
/*     */     
/* 158 */     this.los = new LOS()
/*     */       {
/*     */         public boolean passesToOtherFromThis(int fx, int fy, int tx, int ty)
/*     */         {
/* 162 */           if ((SETT.ROOMS()).fData.tile.get(fx, fy) == ROOM_HOME.this.constructor.tOpening)
/* 163 */             return true; 
/* 164 */           return ((HomeInstance)ROOM_HOME.this.getter.get(fx, fy)).is(tx, ty);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean passesFromOtherToThis(int fx, int fy, int tx, int ty) {
/* 169 */           if ((SETT.ROOMS()).fData.tile.get(tx, ty) == ROOM_HOME.this.constructor.tOpening)
/* 170 */             return true; 
/* 171 */           return ((HomeInstance)ROOM_HOME.this.getter.get(tx, ty)).is(fx, fy);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean blocksEnv(int tx, int ty) {
/* 176 */           return false;
/*     */         }
/*     */         
/*     */         public boolean isLightBlocker(int tx, int ty)
/*     */         {
/* 181 */           return false; }
/*     */       };
/*     */     this.constructor = new HomeContructor(init, this); }
/*     */   protected void update(double ds) {}
/*     */   protected void save(FilePutter file) { this.odd.saver.save(file);
/*     */     HGROUP.MAP().saver().save(this.total, file);
/* 187 */     HGROUP.MAP().saver().save(this.used, file); } public void appendView(LISTE<UIRoomModule> mm) { mm.add(new HomeHoverer());
/* 188 */     super.appendView(mm); }
/*     */   protected void load(FileGetter file) throws IOException { this.odd.saver.load(file); HGROUP.MAP().loader().load(this.total, file, 0); HGROUP.MAP().loader().load(this.used, file, 0); this.totalT = 0; this.usedT = 0; for (HGROUP t : HGROUP.all()) { this.totalT += this.total[t.index()]; this.usedT += this.used[t.index()]; }  }
/*     */   protected void clear() { this.odd.saver.clear(); Arrays.fill(this.total, 0); Arrays.fill(this.used, 0); this.totalT = 0; this.usedT = 0; }
/*     */   void report(int used, int total, HGROUP.HTypeBits s) { for (int i = 0; i < HGROUP.all().size(); i++) { if (s.is(i)) { HGROUP t = (HGROUP)HGROUP.all().get(i); this.usedT += used; this.totalT += total; this.used[t.index()] = this.used[t.index()] + used; this.total[t.index()] = this.total[t.index()] + total; }  }  }
/*     */   public int total(HGROUP t) { if (t == null) return this.totalT;  return this.total[t.index()]; }
/* 193 */   public int used(HGROUP t) { if (t == null) return this.usedT;  return this.used[t.index()]; } public SFinderFindable service(int tx, int ty) { return null; } public COLOR miniC(int tx, int ty) { return this.constructor.miniColor; } public Furnisher constructor() { return this.constructor; } public LOS LOS(int tx, int ty) { return this.los; }
/*     */ 
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\home\house\ROOM_HOME.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */