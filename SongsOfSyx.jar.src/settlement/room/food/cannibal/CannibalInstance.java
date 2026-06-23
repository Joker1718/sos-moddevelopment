/*     */ package settlement.room.food.cannibal;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.faction.FResources;
/*     */ import game.time.TIME;
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.misc.util.RESOURCE_TILE;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.util.RoomInit;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.sets.ArrayCooShort;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ public final class CannibalInstance
/*     */   extends RoomInstance
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private final ArrayCooShort coos;
/*     */   final ArrayCooShort cages;
/*     */   private int[] resources;
/*  28 */   private byte year = (byte)TIME.years().bitsSinceStart();
/*     */   short prisoners;
/*     */   short reservable;
/*     */   
/*     */   CannibalInstance(ROOM_CANNIBAL blue, TmpArea area, RoomInit init) {
/*  33 */     super(blue, area, init);
/*     */     
/*  35 */     this.resources = Alloc.ii((blue.resources()).length);
/*  36 */     int am = 0;
/*  37 */     int ca = 0;
/*  38 */     for (COORDINATE c : body()) {
/*  39 */       if (is(c) && blue.job.init(c.x(), c.y(), this) != null) {
/*  40 */         am++;
/*     */       }
/*  42 */       if (is(c) && blue.cage(c.x(), c.y()) != null) {
/*  43 */         ca++;
/*     */       }
/*     */     } 
/*     */     
/*  47 */     this.coos = new ArrayCooShort(am);
/*  48 */     this.cages = new ArrayCooShort(ca);
/*  49 */     am = 0;
/*  50 */     ca = 0;
/*  51 */     for (COORDINATE c : body()) {
/*  52 */       if (is(c) && blue.job.init(c.x(), c.y(), this) != null) {
/*  53 */         this.coos.set(am++).set(c);
/*     */       }
/*  55 */       if (is(c) && blue.cage(c.x(), c.y()) != null) {
/*  56 */         this.cages.get().set(c);
/*  57 */         this.cages.inc();
/*  58 */         ca++;
/*     */       } 
/*     */     } 
/*  61 */     this.cages.set(0);
/*  62 */     employees().maxSet(ca);
/*  63 */     employees().neededSet((int)Math.ceil(ca / 2.0D));
/*  64 */     activate();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void loadFix() {
/*  70 */     if (this.resources.length != (blueprintI().resources()).length) {
/*  71 */       this.resources = Alloc.ii((blueprintI().resources()).length);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean render(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator it) {
/*  77 */     it.lit();
/*  78 */     return super.render(r, shadowBatch, it);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void activateAction() {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected void deactivateAction() {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateAction(double updateInterval, boolean day) {
/*  93 */     byte y = (byte)TIME.years().bitsSinceStart();
/*  94 */     if (this.year != y) {
/*  95 */       this.year = y;
/*  96 */       for (int i = 0; i < this.resources.length; i++) {
/*  97 */         this.resources[i] = 0;
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dispose() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SETT_JOB getWork() {
/*     */     int i;
/* 112 */     for (i = 0; i < this.coos.size(); i++) {
/* 113 */       this.coos.inc();
/* 114 */       SETT_JOB j = (blueprintI()).job.init(this.coos.get().x(), this.coos.get().y(), this);
/* 115 */       if (!j.jobReservedIs(null)) {
/* 116 */         return j;
/*     */       }
/*     */     } 
/* 119 */     for (i = 0; i < this.coos.size(); i++) {
/* 120 */       this.coos.inc();
/* 121 */       SETT_JOB j = (blueprintI()).job.init(this.coos.get().x(), this.coos.get().y(), this);
/* 122 */       j.jobReserveCancel(null);
/*     */     } 
/*     */     
/* 125 */     for (i = 0; i < this.coos.size(); i++) {
/* 126 */       this.coos.inc();
/* 127 */       SETT_JOB j = (blueprintI()).job.init(this.coos.get().x(), this.coos.get().y(), this);
/* 128 */       if (!j.jobReservedIs(null)) {
/* 129 */         return j;
/*     */       }
/*     */     } 
/* 132 */     return null;
/*     */   }
/*     */   
/*     */   public void resetGore(COORDINATE c) {
/* 136 */     (blueprintI()).job.reset(this, c);
/*     */   }
/*     */   
/*     */   public void gore(COORDINATE c) {
/* 140 */     (blueprintI()).job.gore(this, c);
/*     */   }
/*     */   
/*     */   public SETT_JOB getWork(COORDINATE c) {
/* 144 */     return (blueprintI()).job.init(c.x(), c.y(), this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ROOM_CANNIBAL blueprintI() {
/* 154 */     return (ROOM_CANNIBAL)blueprint();
/*     */   }
/*     */ 
/*     */   
/*     */   public RESOURCE_TILE resourceTile(int tx, int ty) {
/* 159 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public int produce(RESOURCE res, int am) {
/* 164 */     int i = 0; byte b; int j; RESOURCE[] arrayOfRESOURCE;
/* 165 */     for (j = (arrayOfRESOURCE = blueprintI().resources()).length, b = 0; b < j; ) { RESOURCE r = arrayOfRESOURCE[b];
/* 166 */       if (r == res) {
/* 167 */         this.resources[i] = this.resources[i] + am;
/*     */         break;
/*     */       } 
/* 170 */       i++; b++; }
/*     */     
/* 172 */     (blueprintI()).produced[res.index()] = (blueprintI()).produced[res.index()] + am;
/* 173 */     GAME.player().res().inc(res, FResources.RTYPE.PRODUCED, am);
/* 174 */     return i;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\food\cannibal\CannibalInstance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */