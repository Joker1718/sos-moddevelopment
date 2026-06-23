/*     */ package settlement.room.infra.station;
/*     */ 
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.type.HCLASS_RACE;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.finders.SFinderFindable;
/*     */ import settlement.path.finders.SFinderRoomService;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.category.RoomCategorySub;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.job.ROOM_EMPLOY_AUTO;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import view.sett.ui.room.UIRoomModule;
/*     */ 
/*     */ public final class ROOM_STATION
/*     */   extends RoomBlueprintIns<StationInstance>
/*     */   implements ROOM_EMPLOY_AUTO
/*     */ {
/*     */   public static final int MAX_EMPLOYEES = 15;
/*     */   final Constructor constructor;
/*  32 */   final Job job = new Job(this);
/*     */   
/*  34 */   final Crate crate = new Crate(this);
/*  35 */   private final StationTally.Total[] tallies = new StationTally.Total[RESOURCES.ALL().size()];
/*  36 */   private final int[] ri = Alloc.ii(RESOURCES.ALL().size());
/*     */   private final Coo coo;
/*     */   
/*  39 */   public ROOM_STATION(RoomInitData init, RoomCategorySub cat) throws IOException { super(0, init, "_STATION", cat);
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
/* 127 */     this.coo = new Coo(); this.constructor = new Constructor(this, init); for (int i = 0; i < this.tallies.length; i++) this.tallies[i] = new StationTally.Total((RESOURCE)RESOURCES.ALL().get(i));  }
/*     */   protected void update(double ds) {}
/*     */   public Furnisher constructor() { return this.constructor; }
/* 130 */   public SFinderRoomService service(int tx, int ty) { return null; } protected void saveP(FilePutter saveFile) { RESOURCES.map().saver().save(this.ri, saveFile); } protected void loadP(FileGetter saveFile) throws IOException { RESOURCES.map().loader().load(this.ri, saveFile, 0); byte b; int j; StationTally.Total[] arrayOfTotal; for (j = (arrayOfTotal = this.tallies).length, b = 0; b < j; ) { StationTally.Total t = arrayOfTotal[b]; t.clear(); b++; }  int i; for (i = 0; i < instancesSize(); i++) { StationInstance ins = (StationInstance)getInstance(i); ins.bamount = new RBIT.RBITImp(); ins.bcapacity = new RBIT.RBITImp(); ins.tally = new StationTally[RESOURCES.ALL().size()]; for (RESOURCE res : RESOURCES.ALL()) ins.tally[res.index()] = new StationTally();  for (COORDINATE c : ins.body()) { if (ins.is(c) && this.crate.get(c.x(), c.y()) != null && this.crate.get(c.x(), c.y()).resource() != null) ins.tally(this.crate.resource()).add(this.crate.resource(), this.crate, ins);  }  }  for (j = (arrayOfTotal = this.tallies).length, b = 0; b < j; ) { StationTally.Total t = arrayOfTotal[b]; t.clear(); b++; }  for (i = 0; i < instancesSize(); i++) { StationInstance ins = (StationInstance)getInstance(i); byte b1; int k; StationTally.Total[] arrayOfTotal1; for (k = (arrayOfTotal1 = this.tallies).length, b1 = 0; b1 < k; ) { StationTally.Total t = arrayOfTotal1[b1]; t.add(ins.tally(t.res), ins); b1++; }  }  for (j = (arrayOfTotal = this.tallies).length, b = 0; b < j; ) { StationTally.Total t = arrayOfTotal[b]; t.debug(); b++; }  } public COORDINATE reserve(RESOURCE res) { if (tally(res).accepting() <= 0)
/* 131 */       return null; 
/* 132 */     int oi = this.ri[res.index()];
/*     */     
/* 134 */     for (int i = 0; i < instancesSize(); i++) {
/*     */       
/* 136 */       if (oi >= instancesSize())
/* 137 */         oi = 0; 
/* 138 */       StationInstance ins = (StationInstance)getInstance(oi);
/* 139 */       oi++;
/* 140 */       if (ins.accepting(res)) {
/* 141 */         for (COORDINATE c : ins.body()) {
/* 142 */           if (ins.is(c) && ((SETT.ROOMS()).fData.tileData.get(c) & 0x8) != 0) {
/* 143 */             ins.reserve(res);
/* 144 */             this.coo.set(c);
/* 145 */             return (COORDINATE)this.coo;
/*     */           } 
/*     */         } 
/* 148 */         throw new RuntimeException();
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 155 */     int k = 0;
/* 156 */     for (int j = 0; j < instancesSize(); j++) {
/* 157 */       k += ((StationInstance)getInstance(j)).accepting(res) ? 1 : 0;
/*     */     }
/*     */     
/* 160 */     throw new RuntimeException(String.valueOf(res) + " " + String.valueOf(res) + " " + tally(res).accepting() + " " + k); }
/*     */   protected void clearP() {}
/*     */   public void appendView(LISTE<UIRoomModule> mm) { mm.add((new Gui(this)).make()); }
/*     */   public boolean autoEmploy(Room r) { return ((StationInstance)r).auto; }
/* 164 */   public void autoEmploy(Room r, boolean b) { ((StationInstance)r).auto = b; } public StationTally.Total tally(RESOURCE res) { return this.tallies[res.index()]; } public void reserveCancel(RESOURCE res, int tx, int ty) { StationInstance ins = (StationInstance)get(tx, ty);
/* 165 */     if (ins != null)
/* 166 */       ins.unreserve(res);  }
/*     */ 
/*     */   
/*     */   public void deliver(RESOURCE res, int am, int tx, int ty) {
/* 170 */     StationInstance ins = (StationInstance)get(tx, ty);
/* 171 */     if (ins != null)
/* 172 */       ins.deliver(res, am); 
/*     */   }
/*     */   
/*     */   public double workersPerload(int tx, int ty) {
/* 176 */     StationInstance ins = (StationInstance)get(tx, ty);
/* 177 */     if (ins == null)
/* 178 */       return 15.0D; 
/* 179 */     double bo = (SETT.ROOMS()).STOCKPILE.bonus().get((BOOSTABLE_O)HCLASS_RACE.clP()) / ((SETT.ROOMS()).STOCKPILE.bonus()).baseValue;
/* 180 */     return 15.0D / bo * ins.efficiency() * 15.0D;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\station\ROOM_STATION.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */