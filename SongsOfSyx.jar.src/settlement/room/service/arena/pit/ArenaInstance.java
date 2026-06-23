/*     */ package settlement.room.service.arena.pit;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.util.RoomInit;
/*     */ import settlement.room.service.module.ROOM_SERVICER;
/*     */ import settlement.room.service.module.RoomService;
/*     */ import settlement.room.service.module.RoomServiceInstance;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.rnd.RND;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ final class ArenaInstance extends RoomInstance implements ROOM_SERVICER {
/*     */   private static final long serialVersionUID = 1L;
/*  20 */   final byte off = (byte)RND.rInt(64);
/*     */   final RoomServiceInstance service;
/*  22 */   short gladiators = 0;
/*     */   
/*     */   public final byte ax;
/*     */   public final byte ay;
/*     */   int cheerTime;
/*     */   boolean cheer;
/*  28 */   static final int CHEER_TIME = TIME.secondsPerDay() / 128;
/*     */ 
/*     */   
/*     */   protected ArenaInstance(ROOM_FIGHTPIT b, TmpArea area, RoomInit init) {
/*  32 */     super(b, area, init);
/*     */     
/*  34 */     int ss = 0;
/*  35 */     for (COORDINATE c : body()) {
/*  36 */       if (is(c) && b.ser.init(c.x(), c.y())) {
/*  37 */         ss++;
/*     */       }
/*     */     } 
/*     */     
/*  41 */     int ax = 0, ay = 0;
/*     */     int y;
/*  43 */     label25: for (y = 0; y < body().height(); y++) {
/*  44 */       for (int x = 0; x < body().width(); x++) {
/*  45 */         if ((SETT.ROOMS()).fData.tileData.get(body().x1() + x, body().y1() + y) == 2) {
/*  46 */           ax = x;
/*  47 */           ay = y;
/*     */           break label25;
/*     */         } 
/*     */       } 
/*     */     } 
/*  52 */     this.ax = (byte)ax;
/*  53 */     this.ay = (byte)ay;
/*     */     
/*  55 */     this.service = new RoomServiceInstance(ss, (RoomService)(blueprintI()).data);
/*  56 */     int w = (short)(int)b.constructor.workers.get(this);
/*  57 */     employees().maxSet(w);
/*  58 */     employees().neededSet(w);
/*  59 */     activate();
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean render(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator it) {
/*  64 */     it.lit();
/*  65 */     return super.render(r, shadowBatch, it);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void activateAction() {
/*  70 */     this.cheerTime = (int)TIME.currentSecond() - CHEER_TIME;
/*  71 */     blueprintI().incG(this.gladiators, 1);
/*  72 */     for (COORDINATE c : body()) {
/*  73 */       if (is(c) && (blueprintI()).ser.get(c.x(), c.y()) != null) {
/*  74 */         (blueprintI()).ser.findableReserveCancel();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void deactivateAction() {
/*  81 */     blueprintI().incG(-this.gladiators, -1);
/*  82 */     for (COORDINATE c : body()) {
/*  83 */       if (is(c) && (blueprintI()).ser.get(c.x(), c.y()) != null && (blueprintI()).ser.findableReservedCanBe()) {
/*  84 */         (blueprintI()).ser.findableReserve();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateAction(double updateInterval, boolean day) {
/*  92 */     if (day) {
/*  93 */       this.service.updateDay();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dispose() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public ROOM_FIGHTPIT blueprintI() {
/* 104 */     return (ROOM_FIGHTPIT)blueprint();
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomServiceInstance service() {
/* 109 */     return this.service;
/*     */   }
/*     */ 
/*     */   
/*     */   public double quality() {
/* 114 */     return ROOM_SERVICER.defQuality(this, employees().employed() / employees().max());
/*     */   }
/*     */   
/*     */   public int gladiatorsNeeded() {
/* 118 */     if (active())
/* 119 */       return 1 - this.gladiators; 
/* 120 */     return 0;
/*     */   }
/*     */   
/*     */   public void reserveGladiator(int delta) {
/* 124 */     this.gladiators = (short)(this.gladiators + delta);
/* 125 */     if (active())
/* 126 */       blueprintI().incG(delta, 0); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\arena\pit\ArenaInstance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */