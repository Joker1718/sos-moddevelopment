/*     */ package settlement.room.law.execution;
/*     */ 
/*     */ import game.GAME;
/*     */ import init.type.CAUSE_LEAVES;
/*     */ import java.io.IOException;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.FINDABLE;
/*     */ import settlement.misc.util.FSERVICE;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.main.util.RoomAreaWrapper;
/*     */ import settlement.room.main.util.RoomBits;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.bit.Bits;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayCooShort;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class ExecutionStation
/*     */ {
/*     */   public static final int TYPE_CHOP = 1;
/*     */   public static final int TYPE_HANG = 2;
/*     */   public static final int TYPE_GIBBET = 3;
/*     */   public static final int TYPE_CROSS = 4;
/*     */   private final ROOM_EXECTUTION b;
/*  36 */   private RoomAreaWrapper aa = new RoomAreaWrapper();
/*  37 */   private final Coo coo = new Coo();
/*  38 */   private final RoomBits bState = new BB((COORDINATE)this.coo, new Bits(255));
/*  39 */   private final RoomBits bServices = new BB((COORDINATE)this.coo, new Bits(65280));
/*  40 */   private final Client client = new Client();
/*  41 */   private final Guard guard = new Guard();
/*     */   
/*     */   public static final int services = 8;
/*     */   
/*     */   static final int STATE_UNINITED = 0;
/*     */   
/*     */   static final int STATE_RESERVABLE = 1;
/*     */   
/*     */   static final int STATE_RESERVED = 2;
/*     */   static final int STATE_USED = 3;
/*     */   static final int STATE_EXECUTING = 4;
/*     */   static final int STATE_DEAD = 5;
/*  53 */   private ArrayCooShort available = new ArrayCooShort(128);
/*  54 */   private int total = 0;
/*     */ 
/*     */ 
/*     */   
/*     */   private final FSERVICE service;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Client exectuionReserve() {
/*  64 */     if (this.available.getI() == 0) {
/*  65 */       return null;
/*     */     }
/*  67 */     int m = this.available.getI();
/*  68 */     if (m == 0) {
/*  69 */       return null;
/*     */     }
/*  71 */     this.available.set(RND.rInt(m));
/*  72 */     int x = this.available.get().x();
/*  73 */     int y = this.available.get().y();
/*     */     
/*  75 */     if (!isInit(x, y) || this.bState.get() != 1) {
/*  76 */       throw new RuntimeException();
/*     */     }
/*  78 */     this.bState.set(this.aa.area(), 2);
/*     */     
/*  80 */     this.available.swap(this.available.getI(), m - 1);
/*  81 */     this.available.set(m - 1);
/*     */     
/*  83 */     return this.client;
/*     */   }
/*     */   
/*     */   public int total() {
/*  87 */     return this.total;
/*     */   }
/*     */   
/*     */   public int available() {
/*  91 */     return this.available.getI();
/*     */   }
/*     */   
/*     */   public boolean deadORDying(int tx, int ty) {
/*  95 */     if (isInit(tx, ty))
/*  96 */       return (this.bState.get() >= 3); 
/*  97 */     return false;
/*     */   }
/*     */   
/*     */   void save(FilePutter f) {
/* 101 */     f.object(this.available);
/* 102 */     f.i(this.total);
/*     */   }
/*     */   
/*     */   void load(FileGetter f) throws IOException {
/* 106 */     this.available = (ArrayCooShort)f.object();
/* 107 */     this.total = f.i();
/*     */   }
/*     */   
/*     */   void clear() {
/* 111 */     this.available = new ArrayCooShort(128);
/* 112 */     this.total = 0;
/*     */   }
/*     */   
/*     */   void init(int tx, int ty) {
/* 116 */     if (isInit(tx, ty)) {
/* 117 */       this.total++;
/* 118 */       this.available.get().set(tx, ty);
/* 119 */       this.bState.set(this.aa.area(), 1);
/*     */     } 
/*     */   }
/*     */   
/*     */   void dispose(int tx, int ty) {
/* 124 */     if (isInit(tx, ty)) {
/* 125 */       this.total--;
/* 126 */       int m = this.available.getI();
/* 127 */       for (int i = 0; i < m; i++) {
/* 128 */         if (this.available.set(i).isSameAs(tx, ty)) {
/* 129 */           this.available.swap(i, m - 1);
/* 130 */           this.available.set(m - 1);
/*     */           break;
/*     */         } 
/*     */       } 
/* 134 */       this.bState.set(this.aa.area(), 0);
/*     */     } 
/*     */   }
/*     */   
/*     */   private boolean isInit(int tx, int ty) {
/* 139 */     Room r = (SETT.ROOMS()).map.get(tx, ty);
/* 140 */     if (r != (SETT.ROOMS()).EXECUTION.instance) {
/* 141 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 145 */     int c = (SETT.ROOMS()).fData.tileData.get(tx, ty);
/* 146 */     if (c <= 0)
/* 147 */       return false; 
/* 148 */     this.aa.done();
/* 149 */     this.aa.init(r, tx, ty);
/* 150 */     this.coo.set(tx, ty);
/* 151 */     return true;
/*     */   }
/*     */   
/*     */   public int type(int tx, int ty) {
/* 155 */     return (SETT.ROOMS()).fData.tileData.get(tx, ty);
/*     */   }
/*     */   
/*     */   public FSERVICE service(int tx, int ty) {
/* 159 */     if (isInit(tx, ty))
/* 160 */       return this.service; 
/* 161 */     return null;
/*     */   }
/*     */   
/*     */   public Client client(int tx, int ty) {
/* 165 */     if (isInit(tx, ty))
/* 166 */       return this.client; 
/* 167 */     return null;
/*     */   }
/*     */   
/*     */   public Guard guard(int tx, int ty) {
/* 171 */     if (isInit(tx, ty))
/* 172 */       return this.guard; 
/* 173 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public class Client
/*     */   {
/*     */     public boolean clientReserved() {
/* 181 */       return (ExecutionStation.this.bState.get() >= 2);
/*     */     }
/*     */     
/*     */     public boolean clientPresent() {
/* 185 */       return (ExecutionStation.this.bState.get() > 2);
/*     */     }
/*     */ 
/*     */     
/*     */     public void clientUse() {
/* 190 */       ExecutionStation.this.bState.set(ExecutionStation.this.aa.area(), 3);
/*     */     }
/*     */     
/*     */     public void clientCancel() {
/* 194 */       if ((SETT.THINGS()).corpses.tGet.get((COORDINATE)ExecutionStation.this.coo) != null) {
/* 195 */         ExecutionStation.this.bState.set(ExecutionStation.this.aa.area(), 5);
/*     */       } else {
/* 197 */         ExecutionStation.this.bState.set(ExecutionStation.this.aa.area(), 1);
/*     */       } 
/*     */     }
/*     */     public boolean clientBeingExecuted() {
/* 201 */       return (ExecutionStation.this.bState.get() == 4);
/*     */     }
/*     */     
/*     */     public DIR clientDir() {
/* 205 */       return (DIR)DIR.ORTHO.get(((FurnisherItem)(SETT.ROOMS()).fData.item.get((COORDINATE)ExecutionStation.this.coo)).rotation);
/*     */     }
/*     */     
/*     */     public COORDINATE coo() {
/* 209 */       return (COORDINATE)ExecutionStation.this.coo;
/*     */     }
/*     */   }
/*     */   
/*     */   public class Guard
/*     */   {
/*     */     public boolean active() {
/* 216 */       if (ExecutionStation.this.bState.get() >= 1 && ExecutionStation.this.bState.get() < 5)
/* 217 */         return true; 
/* 218 */       return false;
/*     */     }
/*     */     
/*     */     public boolean shouldExecute() {
/* 222 */       return (ExecutionStation.this.bState.get() == 3);
/*     */     }
/*     */     
/*     */     public boolean workExecute() {
/* 226 */       if (ExecutionStation.this.bState.get() == 3) {
/* 227 */         ExecutionStation.this.bState.set(ExecutionStation.this.aa.area(), 4);
/*     */         
/* 229 */         if (ExecutionStation.this.type(ExecutionStation.this.coo.x(), ExecutionStation.this.coo.y()) == 1) {
/* 230 */           for (ENTITY e : SETT.ENTITIES().getAtTile(ExecutionStation.this.coo.x(), ExecutionStation.this.coo.y())) {
/* 231 */             if (e instanceof Humanoid) {
/* 232 */               Humanoid a = (Humanoid)e;
/* 233 */               (STATS.NEEDS()).INJURIES.COUNT.indu().incD(a.indu(), 0.2D + RND.rFloat());
/* 234 */               (SETT.THINGS()).gore.cloud((ENTITY)a, (a.race().appearance()).colors.blood);
/* 235 */               (SETT.THINGS()).gore.flesh((ENTITY)a, (a.race().appearance()).colors.blood);
/* 236 */               if ((STATS.NEEDS()).INJURIES.COUNT.indu().getD(a.indu()) > 0.75D) {
/* 237 */                 (GAME.count()).EXECUTIONS.inc(1);
/* 238 */                 (STATS.NEEDS()).INJURIES.COUNT.indu().setD(a.indu(), 1.0D);
/* 239 */                 a.kill(false, CAUSE_LEAVES.EXECUTED());
/* 240 */                 ExecutionStation.this.client.clientCancel();
/*     */               } 
/* 242 */               return true;
/*     */             } 
/*     */           } 
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 249 */       return false;
/*     */     }
/*     */     
/*     */     public COORDINATE coo() {
/* 253 */       return (COORDINATE)ExecutionStation.this.coo;
/*     */     }
/*     */   }
/*     */   
/*     */   ExecutionStation(ROOM_EXECTUTION b) {
/* 258 */     this.service = new FSERVICE()
/*     */       {
/*     */         
/*     */         public int y()
/*     */         {
/* 263 */           return ExecutionStation.this.coo.y();
/*     */         }
/*     */ 
/*     */         
/*     */         public int x() {
/* 268 */           return ExecutionStation.this.coo.x();
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean findableReservedIs() {
/* 273 */           return (ExecutionStation.this.bServices.get() > 0);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean findableReservedCanBe() {
/* 278 */           return (ExecutionStation.this.bState.get() == 1 && ExecutionStation.this.bServices.get() < 8);
/*     */         }
/*     */ 
/*     */         
/*     */         public void findableReserveCancel() {
/* 283 */           ExecutionStation.this.bServices.inc(ExecutionStation.this.aa.area(), 1);
/*     */         }
/*     */ 
/*     */         
/*     */         public void findableReserve() {
/* 288 */           ExecutionStation.this.bServices.inc(ExecutionStation.this.aa.area(), -1);
/*     */         }
/*     */ 
/*     */         
/*     */         public void consume() {
/* 293 */           ExecutionStation.this.bServices.inc(ExecutionStation.this.aa.area(), 1);
/*     */         }
/*     */       };
/*     */     this.b = b;
/*     */   }
/*     */   
/*     */   private final class BB extends RoomBits { public BB(COORDINATE coo, Bits bits) {
/* 300 */       super(coo, bits);
/*     */     }
/*     */ 
/*     */     
/*     */     public void set(ROOMA r, int t) {
/* 305 */       boolean av = (ExecutionStation.this.bState.get() == 1);
/* 306 */       boolean requested = (ExecutionStation.this.bState.get() == 2);
/* 307 */       if (ExecutionStation.this.service.findableReservedCanBe())
/* 308 */         ExecutionStation.this.b.data.report((FINDABLE)ExecutionStation.this.service, -1); 
/* 309 */       super.set(r, t);
/* 310 */       if (ExecutionStation.this.service.findableReservedCanBe())
/* 311 */         ExecutionStation.this.b.data.report((FINDABLE)ExecutionStation.this.service, 1); 
/* 312 */       if (!av && ExecutionStation.this.bState.get() == 1) {
/* 313 */         if (ExecutionStation.this.available.getI() - 1 >= ExecutionStation.this.available.size()) {
/* 314 */           ArrayCooShort nn = new ArrayCooShort(ExecutionStation.this.available.size() + 128);
/* 315 */           for (int i = ExecutionStation.this.available.getI() - 1; i >= 0; i--) {
/* 316 */             nn.set(i).set((COORDINATE)ExecutionStation.this.available.set(i));
/*     */           }
/* 318 */           ExecutionStation.this.available = nn;
/*     */         } 
/* 320 */         ExecutionStation.this.available.get().set(ExecutionStation.this.coo.x(), ExecutionStation.this.coo.y());
/* 321 */         ExecutionStation.this.available.inc();
/*     */       } 
/* 323 */       if (!requested && ExecutionStation.this.bState.get() == 2) {
/* 324 */         int tx = ExecutionStation.this.coo.x();
/* 325 */         int ty = ExecutionStation.this.coo.y();
/* 326 */         (SETT.ROOMS()).GUARD.reporter.reportExecution(tx, ty);
/* 327 */         ExecutionStation.this.isInit(tx, ty);
/*     */       } 
/*     */     } }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void update(int tx, int ty) {
/* 335 */     if (isInit(tx, ty) && 
/* 336 */       this.bState.get() == 5 && 
/* 337 */       (SETT.THINGS()).corpses.tGet.get(tx, ty) == null) {
/* 338 */       this.bState.set(this.aa.area(), 1);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int sevices(int tx, int ty) {
/* 347 */     if (service(tx, ty) != null && 
/* 348 */       this.bState.get() == 5) {
/* 349 */       return 8 - this.bServices.get();
/*     */     }
/*     */     
/* 352 */     return 0;
/*     */   }
/*     */   
/*     */   int state(int tx, int ty) {
/* 356 */     if (service(tx, ty) != null) {
/* 357 */       return this.bState.get();
/*     */     }
/* 359 */     return 0;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\law\execution\ExecutionStation.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */