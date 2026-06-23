/*     */ package settlement.room.service.arena.pit;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.FSERVICE;
/*     */ import settlement.path.finders.SFinderFindable;
/*     */ import settlement.path.finders.SFinderRoomService;
/*     */ import settlement.room.law.PUNISHMENT_SERVICE;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.category.RoomCategorySub;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import settlement.room.service.arena.RoomArenaGui;
/*     */ import settlement.room.service.arena.RoomArenaWork;
/*     */ import settlement.room.service.module.ROOM_SPECTATOR;
/*     */ import settlement.room.service.module.RoomService;
/*     */ import settlement.room.service.module.RoomServiceAccess;
/*     */ import settlement.room.service.module.RoomServiceNeed;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import util.data.BOOLEANO;
/*     */ import util.info.INFO;
/*     */ import util.text.D;
/*     */ import view.sett.ui.room.UIRoomModule;
/*     */ 
/*     */ public final class ROOM_FIGHTPIT
/*     */   extends RoomBlueprintIns<ArenaInstance>
/*     */   implements RoomServiceNeed.ROOM_SERVICE_NEED_HASER, ROOM_SPECTATOR.ROOM_SPECTATOR_HASER, PUNISHMENT_SERVICE {
/*  40 */   public static CharSequence ¤¤kill = "Strength and Honor";
/*  41 */   public static CharSequence ¤¤killD = "Enable prisoners condemned to die to do so on the sands of the arena.";
/*     */   
/*     */   static {
/*  44 */     D.ts(ROOM_FIGHTPIT.class);
/*     */   }
/*     */ 
/*     */   
/*     */   final RoomServiceNeed data;
/*     */   final Service ser;
/*     */   static final int EXECUTIONS = 1;
/*     */   final ArenaConstructor constructor;
/*  52 */   private int gladiators = 0;
/*  53 */   private int gladiatorMax = 0;
/*     */   
/*  55 */   private final BOOLEANO.BooleanOEImp<Race> permission = new BOOLEANO.BooleanOEImp(RACES.all().size(), true);
/*     */   
/*     */   public ROOM_FIGHTPIT(String key, int index, RoomInitData init, RoomCategorySub block) throws IOException {
/*  58 */     super(index, init, key, block);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 135 */     this.spec = new ROOM_SPECTATOR()
/*     */       {
/* 137 */         private Coo coo = new Coo();
/*     */ 
/*     */         
/*     */         public RoomServiceAccess service() {
/* 141 */           return (RoomServiceAccess)ROOM_FIGHTPIT.this.service();
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public COORDINATE lookAt(int sx, int sy) {
/* 148 */           ArenaInstance ins = (ArenaInstance)ROOM_FIGHTPIT.this.getter.get(sx, sy);
/* 149 */           if (ins == null) {
/* 150 */             this.coo.set(sx, sy);
/*     */           } else {
/* 152 */             this.coo.set(sx, sy);
/* 153 */             RECTANGLE rec = ROOM_FIGHTPIT.this.work.gladiatorArea(sx, sy);
/* 154 */             int w = Math.min(4, rec.width());
/* 155 */             int h = Math.min(4, rec.height());
/* 156 */             int a = w * h;
/* 157 */             int i = (sx + sy) % a;
/* 158 */             this.coo.set((rec.cX() - w / 2 + i % w), (rec.cY() - h / 2 + i / h));
/*     */           } 
/* 160 */           this.coo.set((this.coo.x() * 64 + 32), (this.coo.y() * 64 + 32));
/* 161 */           return (COORDINATE)this.coo;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean is(int sx, int sy) {
/* 166 */           ArenaInstance ins = (ArenaInstance)ROOM_FIGHTPIT.this.getter.get(sx, sy);
/* 167 */           return (ins != null);
/*     */         }
/*     */         
/*     */         private int activity(int sx, int sy) {
/* 171 */           ArenaInstance ins = (ArenaInstance)ROOM_FIGHTPIT.this.getter.get(sx, sy);
/* 172 */           if (ins == null) {
/* 173 */             return 0;
/*     */           }
/* 175 */           int d = (int)TIME.currentSecond() - ins.cheerTime;
/*     */           
/* 177 */           if (d > ArenaInstance.CHEER_TIME * 8) {
/* 178 */             ins.cheerTime = (int)TIME.currentSecond();
/* 179 */             ins.cheer = false;
/* 180 */             d = 0;
/*     */           } 
/*     */           
/* 183 */           if (d <= ArenaInstance.CHEER_TIME) {
/* 184 */             if (ins.cheer)
/* 185 */               return 1; 
/* 186 */             return 2;
/*     */           } 
/*     */           
/* 189 */           return 0;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean shouldCheer(int sx, int sy) {
/* 194 */           return (activity(sx, sy) == 1);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean shouldBoo(int sx, int sy) {
/* 199 */           return (activity(sx, sy) == 2);
/*     */         }
/*     */ 
/*     */         
/*     */         public COORDINATE getDestination(COORDINATE roomT) {
/* 204 */           this.coo.set(roomT.x(), roomT.y());
/* 205 */           return (COORDINATE)this.coo;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean isSpot(int tx, int ty) {
/* 210 */           if (ROOM_FIGHTPIT.this.ser.init(tx, ty))
/* 211 */             return true; 
/* 212 */           return super.isSpot(tx, ty);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean isOpenNow() {
/* 217 */           return !(TIME.hours().bitCurrent() <= 11 && TIME.hours().bitCurrent() >= 6);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean isActive(int sx, int sy) {
/* 222 */           ArenaInstance ins = (ArenaInstance)ROOM_FIGHTPIT.this.getter.get(sx, sy);
/* 223 */           return (ins != null && ins.employees().employed() > 0);
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 234 */     this.coo = new Coo();
/* 235 */     this.aArea = new Rec();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 256 */     this.work = new RoomArenaWork()
/*     */       {
/*     */         public void unreserveDeath(int tx, int ty)
/*     */         {
/* 260 */           ArenaInstance ins = (ArenaInstance)ROOM_FIGHTPIT.this.getter.get(tx, ty);
/* 261 */           if (ins != null) {
/* 262 */             ins.reserveGladiator(-1);
/*     */           }
/*     */         }
/*     */         
/*     */         public RoomInstance reserveDeath(COORDINATE coo) {
/* 267 */           if (ROOM_FIGHTPIT.this.gladiatorMax == 0 || ROOM_FIGHTPIT.this.gladiators >= ROOM_FIGHTPIT.this.gladiatorMax) {
/* 268 */             return null;
/*     */           }
/*     */           
/* 271 */           ArenaInstance ins = (ArenaInstance)ROOM_FIGHTPIT.this.getter.get(coo);
/* 272 */           if (ins != null && ins.gladiatorsNeeded() > 0) {
/* 273 */             ins.reserveGladiator(1);
/* 274 */             return ins;
/*     */           } 
/*     */ 
/*     */           
/* 278 */           int ri = RND.rInt(ROOM_FIGHTPIT.this.instancesSize());
/*     */           
/* 280 */           for (int i = 0; i < ROOM_FIGHTPIT.this.instancesSize(); i++) {
/* 281 */             ArenaInstance arenaInstance = (ArenaInstance)ROOM_FIGHTPIT.this.getInstance((i + ri) % ROOM_FIGHTPIT.this.instancesSize());
/* 282 */             if (arenaInstance.gladiatorsNeeded() > 0) {
/* 283 */               arenaInstance.reserveGladiator(1);
/* 284 */               return arenaInstance;
/*     */             } 
/*     */           } 
/* 287 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean gladiatorInArena(int tx, int ty) {
/* 292 */           ArenaInstance ins = (ArenaInstance)ROOM_FIGHTPIT.this.getter.get(tx, ty);
/* 293 */           return (ins != null && (SETT.ROOMS()).fData.tileData.get(tx, ty) == 2);
/*     */         }
/*     */ 
/*     */         
/*     */         public COORDINATE gladiatorGetSpot(RoomInstance i) {
/* 298 */           ArenaInstance ins = (ArenaInstance)i;
/* 299 */           int w = ins.body().width() - ins.ax * 2;
/* 300 */           int h = ins.body().height() - ins.ay * 2;
/* 301 */           ROOM_FIGHTPIT.this.coo.set((ins.body().x1() + ins.ax + RND.rInt(w)), (ins.body().y1() + ins.ay + RND.rInt(h)));
/* 302 */           if (!gladiatorInArena(ROOM_FIGHTPIT.this.coo.x(), ROOM_FIGHTPIT.this.coo.y()))
/* 303 */             throw new RuntimeException(String.valueOf(ROOM_FIGHTPIT.this.coo)); 
/* 304 */           return (COORDINATE)ROOM_FIGHTPIT.this.coo;
/*     */         }
/*     */ 
/*     */         
/*     */         public void gladiatorDrawMakeSheer(COORDINATE coo) {
/* 309 */           ArenaInstance ins = (ArenaInstance)ROOM_FIGHTPIT.this.getter.get(coo);
/* 310 */           if (ins != null) {
/* 311 */             ins.cheerTime = (int)TIME.currentSecond();
/* 312 */             ins.cheer = !RND.oneIn(6);
/*     */           } 
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public RECTANGLE gladiatorArea(int tx, int ty) {
/* 319 */           ArenaInstance ins = (ArenaInstance)ROOM_FIGHTPIT.this.getter.get(tx, ty);
/* 320 */           if (ins == null)
/* 321 */             return null; 
/* 322 */           ROOM_FIGHTPIT.this.aArea.setDim((ins.body().width() - ins.ax * 2), (ins.body().height() - ins.ay * 2));
/* 323 */           ROOM_FIGHTPIT.this.aArea.moveX1Y1((ins.body().x1() + ins.ax), (ins.body().y1() + ins.ay));
/* 324 */           return (RECTANGLE)ROOM_FIGHTPIT.this.aArea;
/*     */         }
/*     */ 
/*     */         
/*     */         public int executions(RoomInstance ins) {
/* 329 */           if (ins instanceof ArenaInstance) {
/* 330 */             ArenaInstance i = (ArenaInstance)ins;
/* 331 */             return i.gladiators;
/*     */           } 
/* 333 */           return 0;
/*     */         }
/*     */ 
/*     */         
/*     */         public int executionsMax(RoomInstance ins) {
/* 338 */           return 1;
/*     */         }
/*     */ 
/*     */         
/*     */         public int executions() {
/* 343 */           return ROOM_FIGHTPIT.this.gladiators;
/*     */         }
/*     */ 
/*     */         
/*     */         public int executionsMax() {
/* 348 */           return ROOM_FIGHTPIT.this.gladiatorMax;
/*     */         }
/*     */       };
/*     */     this.ser = new Service(this);
/*     */     this.data = new RoomServiceNeed((RoomBlueprintImp)this, init) {
/*     */         public FSERVICE service(int tx, int ty) {
/*     */           return ROOM_FIGHTPIT.this.ser.get(tx, ty);
/*     */         }
/*     */       };
/*     */     this.constructor = new ArenaConstructor(this, init);
/*     */     employment().setShiftStart(ROOM_SPECTATOR.WORK_STARTSD, false);
/*     */     this.permission.info = new INFO(¤¤kill, ¤¤killD);
/*     */   }
/*     */   private final ROOM_SPECTATOR spec;
/*     */   private final Coo coo;
/*     */   private final Rec aArea;
/*     */   public final RoomArenaWork work;
/*     */   
/*     */   protected void update(double ds) {}
/*     */   
/*     */   public void appendView(LISTE<UIRoomModule> mm) {
/*     */     mm.add(new RoomArenaGui(this.work));
/*     */   }
/*     */   
/*     */   void incG(int g, int m) {
/*     */     this.gladiators += g;
/*     */     this.gladiatorMax += m;
/*     */   }
/*     */   
/*     */   public Furnisher constructor() {
/*     */     return this.constructor;
/*     */   }
/*     */   
/*     */   public SFinderRoomService service(int tx, int ty) {
/*     */     return this.data.finder;
/*     */   }
/*     */   
/*     */   protected void saveP(FilePutter saveFile) {
/*     */     this.data.saver.save(saveFile);
/*     */     saveFile.i(this.gladiators);
/*     */     saveFile.i(this.gladiatorMax);
/*     */     this.permission.save(saveFile);
/*     */   }
/*     */   
/*     */   protected void loadP(FileGetter saveFile) throws IOException {
/*     */     this.data.saver.load(saveFile);
/*     */     this.gladiators = saveFile.i();
/*     */     this.gladiatorMax = saveFile.i();
/*     */     this.gladiators = 0;
/*     */     for (int i = 0; i < instancesSize(); i++) {
/*     */       ArenaInstance ins = (ArenaInstance)getInstance(i);
/*     */       this.gladiators += ins.gladiators;
/*     */     } 
/*     */     this.permission.load(saveFile);
/*     */   }
/*     */   
/*     */   protected void clearP() {
/*     */     this.data.saver.clear();
/*     */     this.gladiators = 0;
/*     */     this.gladiatorMax = 0;
/*     */     this.permission.clear();
/*     */   }
/*     */   
/*     */   public RoomServiceNeed service() {
/*     */     return this.data;
/*     */   }
/*     */   
/*     */   public ROOM_SPECTATOR spec() {
/*     */     return this.spec;
/*     */   }
/*     */   
/*     */   public static boolean gamesAreHeld() {
/*     */     return (TIME.hours().bitCurrent() >= 8);
/*     */   }
/*     */   
/*     */   public int punishTotal() {
/*     */     return this.gladiatorMax;
/*     */   }
/*     */   
/*     */   public int punishUsed() {
/*     */     return this.gladiators;
/*     */   }
/*     */   
/*     */   public BOOLEANO.BOOLEAN_OE<Race> punishEnabled() {
/*     */     return (BOOLEANO.BOOLEAN_OE<Race>)this.permission;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\arena\pit\ROOM_FIGHTPIT.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */