/*     */ package settlement.room.spirit.temple;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.time.TIME;
/*     */ import init.race.Race;
/*     */ import init.religion.RELIGIONS;
/*     */ import init.religion.Religion;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.type.NEED;
/*     */ import init.type.NEEDS;
/*     */ import java.io.IOException;
/*     */ import settlement.misc.util.FSERVICE;
/*     */ import settlement.path.finders.SFinderFindable;
/*     */ import settlement.path.finders.SFinderRoomService;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.category.RoomCategorySub;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import settlement.room.service.module.RoomService;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import view.sett.ui.room.UIRoomModule;
/*     */ 
/*     */ public class ROOM_TEMPLE
/*     */   extends RoomBlueprintIns<TempleInstance> implements RoomService.ROOM_SERVICE_HASER {
/*  30 */   int consumed = 0;
/*  31 */   private int year = TIME.years().bitsSinceStart();
/*     */   final TempleConstructor constructor;
/*     */   final RoomService service;
/*     */   final Service serviceTile;
/*     */   final TempleJob job;
/*     */   final TempleAltar altar;
/*     */   public final RESOURCE resource;
/*     */   public final double STIME;
/*  39 */   private double searchCooloff = 0.0D;
/*     */   public static final String TYPE = "TEMPLE"; public final Religion religion; int si; public void appendView(LISTE<UIRoomModule> mm) {
/*     */     mm.add((new Gui(this)).make());
/*     */   } protected void saveP(FilePutter f) {
/*     */     this.service.saver.save(f);
/*     */     f.i(this.consumed);
/*  45 */   } public ROOM_TEMPLE(int typeIndex, RoomInitData data, String key, RoomCategorySub cat) throws IOException { super(typeIndex, data, key, cat);
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
/* 135 */     this.si = 0; this.constructor = new TempleConstructor(this, data); this.serviceTile = new Service(this); this.service = new RoomService((RoomBlueprintImp)this, data, (NEEDS.TYPES()).TEMPLE) {
/*     */         public FSERVICE service(int tx, int ty) { return ROOM_TEMPLE.this.serviceTile.get(tx, ty); }
/*     */       }; this.religion = (Religion)RELIGIONS.MAP().read(data.data()); String str; switch ((str = data.data().value("SACRIFICE_TYPE")).hashCode()) { case 69101837: if (str.equals("HUMAN")) { this.resource = null; this.job = new TempleJob.None(this); this.altar = new TempleAltar.Prisoner(this); break; } case 441562126: if (str.equals("RESOURCE")) { this.resource = (RESOURCE)RESOURCES.map().read("SACRIFICE_RESOURCE", data.data()); this.job = new TempleJob.Resources(this, this.resource); this.altar = new TempleAltar.Resource(this, this.resource); break; } case 1935180284: if (str.equals("ANIMAL")) { this.resource = RESOURCES.LIVESTOCK(); this.job = new TempleJob.Resources(this, this.resource); this.altar = new TempleAltar.Animal(this); break; } default: this.resource = null; this.job = null; this.altar = null; data.data().error(data.data().value("SACRIFICE_TYPE") + " is not a sacrifice type. Pick from RESOURCES,", "SACRIFICE_TYPE"); break; }  this.STIME = data.data().d("SACRIFICE_TIME", 0.0D, 10.0D); }
/* 138 */   protected void loadP(FileGetter f) throws IOException { this.service.saver.load(f); this.consumed = f.i(); } protected void clearP() { this.service.saver.clear(); this.consumed = 0; this.year = TIME.years().bitsSinceStart(); } public COORDINATE sacrificeReserve(Race race) { if (!(this.altar instanceof TempleAltar.Prisoner)) {
/* 139 */       return null;
/*     */     }
/* 141 */     if (this.searchCooloff > 0.0D) {
/* 142 */       return null;
/*     */     }
/* 144 */     for (int i = 0; i < instancesSize(); i++) {
/* 145 */       this.si %= instancesSize();
/* 146 */       TempleInstance ins = (TempleInstance)getInstance(this.si);
/* 147 */       this.si++;
/* 148 */       if (ins.sacrificesRequired > 0) {
/* 149 */         int old = ins.jobs.getI();
/* 150 */         for (int j = 0; j < ins.jobs.size(); j++) {
/* 151 */           if (this.job.get(ins.jobs.set(j).x(), ins.jobs.get().y()) != null) {
/* 152 */             TempleAltar.Prisoner p = (TempleAltar.Prisoner)this.altar.get(this.job.faceCoo().x(), this.job.faceCoo().y());
/* 153 */             if (p.sacrificeReservable()) {
/* 154 */               ins.jobs.set(old);
/* 155 */               p.sacrificeReserve(race);
/* 156 */               return p.coo();
/*     */             } 
/*     */           } 
/*     */         } 
/*     */         
/* 161 */         ins.jobs.set(old);
/* 162 */         GAME.Notify("Weird!");
/*     */       } 
/*     */     } 
/*     */     
/* 166 */     this.searchCooloff = 60.0D;
/* 167 */     return null; } protected void update(double ds) { if (this.year != TIME.years().bitsSinceStart()) { this.consumed = 0; this.year = TIME.years().bitsSinceStart(); }  this.searchCooloff -= ds; if (this.searchCooloff < 0.0D)
/*     */       this.searchCooloff = 0.0D;  }
/*     */   public SFinderRoomService service(int tx, int ty) { return this.service.finder; }
/*     */   public Furnisher constructor() { return this.constructor; }
/*     */   public RoomService service() { return this.service; }
/* 172 */   public boolean sacrifices() { if (!(this.altar instanceof TempleAltar.Prisoner)) {
/* 173 */       return false;
/*     */     }
/* 175 */     return true; }
/*     */ 
/*     */   
/*     */   public boolean sacrificeReserved(COORDINATE coo) {
/* 179 */     if (this.altar.get(coo.x(), coo.y()) == null)
/* 180 */       return false; 
/* 181 */     if (!(this.altar instanceof TempleAltar.Prisoner)) {
/* 182 */       return false;
/*     */     }
/* 184 */     TempleAltar.Prisoner p = (TempleAltar.Prisoner)this.altar;
/* 185 */     return p.sacrificeReserved();
/*     */   }
/*     */   
/*     */   public void sacrificeUnreserve(COORDINATE coo) {
/* 189 */     if (this.altar.get(coo.x(), coo.y()) == null)
/*     */       return; 
/* 191 */     if (!(this.altar instanceof TempleAltar.Prisoner)) {
/*     */       return;
/*     */     }
/* 194 */     TempleAltar.Prisoner p = (TempleAltar.Prisoner)this.altar;
/* 195 */     p.sacrificeUnreserve();
/*     */   }
/*     */   
/*     */   public void sacrificeSetReady(COORDINATE coo) {
/* 199 */     if (this.altar.get(coo.x(), coo.y()) == null)
/*     */       return; 
/* 201 */     if (!(this.altar instanceof TempleAltar.Prisoner)) {
/*     */       return;
/*     */     }
/* 204 */     TempleAltar.Prisoner p = (TempleAltar.Prisoner)this.altar;
/* 205 */     p.sacrificeReady();
/*     */   }
/*     */   
/*     */   public double sacrificeKillAmount(COORDINATE coo) {
/* 209 */     if (this.altar.get(coo.x(), coo.y()) == null)
/* 210 */       return 0.0D; 
/* 211 */     if (!(this.altar instanceof TempleAltar.Prisoner)) {
/* 212 */       return 0.0D;
/*     */     }
/* 214 */     TempleAltar.Prisoner p = (TempleAltar.Prisoner)this.altar;
/* 215 */     return p.sacrificeKillAmount();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\spirit\temple\ROOM_TEMPLE.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */