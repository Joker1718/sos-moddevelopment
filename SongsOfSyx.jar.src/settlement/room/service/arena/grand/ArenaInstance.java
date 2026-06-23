/*     */ package settlement.room.service.arena.grand;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.time.TIME;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.furnisher.FurnisherItemTile;
/*     */ import settlement.room.main.util.RoomInit;
/*     */ import settlement.room.service.module.ROOM_SERVICER;
/*     */ import settlement.room.service.module.RoomService;
/*     */ import settlement.room.service.module.RoomServiceInstance;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ final class ArenaInstance extends RoomInstance implements ROOM_SERVICER {
/*     */   private static final long serialVersionUID = 1L;
/*  24 */   static final int CHEER_TIME = TIME.secondsPerDay() / 128;
/*     */   final RoomServiceInstance service;
/*     */   final RECTANGLE arena;
/*  27 */   byte executions = 0;
/*     */   int cheerTime;
/*     */   boolean cheer;
/*     */   
/*     */   protected ArenaInstance(ROOM_ARENA b, TmpArea area, RoomInit init, RECTANGLE aa) {
/*  32 */     super(b, area, init);
/*  33 */     this.arena = aa;
/*     */     
/*  35 */     int ww = 0;
/*  36 */     int ss = 0;
/*     */     
/*  38 */     GAME.Notify("here");
/*     */ 
/*     */     
/*  41 */     for (COORDINATE c : body()) {
/*  42 */       if (is(c)) {
/*     */         
/*  44 */         if (b.constructor.util.tile(c.x(), c.y()) == b.constructor.util.iArena)
/*  45 */           ww++; 
/*  46 */         if (b.constructor.util.service(c.x(), c.y())) {
/*  47 */           ss++;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  52 */     this.service = new RoomServiceInstance(ss, (RoomService)(blueprintI()).data);
/*  53 */     employees().maxSet(ww / 6);
/*  54 */     employees().neededSet(ww / 6);
/*     */     
/*  56 */     activate();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void activateAction() {
/*  62 */     (blueprintI()).executions -= this.executions;
/*  63 */     (blueprintI()).executionsMax += 4;
/*  64 */     for (COORDINATE c : body()) {
/*  65 */       if (is(c) && (blueprintI()).ser.get(c.x(), c.y()) != null) {
/*  66 */         (blueprintI()).ser.findableReserveCancel();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void deactivateAction() {
/*  73 */     (blueprintI()).executions += this.executions;
/*  74 */     (blueprintI()).executionsMax -= 4;
/*  75 */     for (COORDINATE c : body()) {
/*  76 */       if (is(c) && (blueprintI()).ser.get(c.x(), c.y()) != null && (blueprintI()).ser.findableReservedCanBe()) {
/*  77 */         (blueprintI()).ser.findableReserve();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void updateAction(double updateInterval, boolean day) {
/*  84 */     if (day) {
/*  85 */       this.service.updateDay();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomServiceInstance service() {
/*  91 */     return this.service;
/*     */   }
/*     */ 
/*     */   
/*     */   public double quality() {
/*  96 */     return ROOM_SERVICER.defQuality(this, employees().employed() / employees().max());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dispose() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public ROOM_ARENA blueprintI() {
/* 106 */     return (ROOM_ARENA)blueprint();
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean render(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator i) {
/* 111 */     i.lit();
/* 112 */     FurnisherItemTile s = (blueprintI()).constructor.util.tile(i.tile());
/* 113 */     return s.sprite.render((SPRITE_RENDERER)r, shadowBatch, (SETT.ROOMS()).fData.spriteData.get(i.tile()), i, getDegrade(), false);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean renderAbove(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator i) {
/* 118 */     FurnisherItemTile s = (blueprintI()).constructor.util.tile(i.tile());
/* 119 */     s.sprite.renderAbove((SPRITE_RENDERER)r, shadowBatch, (SETT.ROOMS()).fData.spriteData.get(i.tile()), i, getDegrade());
/* 120 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean renderBelow(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator i) {
/* 125 */     FurnisherItemTile s = (blueprintI()).constructor.util.tile(i.tile());
/* 126 */     s.sprite.renderBelow((SPRITE_RENDERER)r, shadowBatch, (SETT.ROOMS()).fData.spriteData.get(i.tile()), i, getDegrade());
/* 127 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected AVAILABILITY getAvailability(int tile) {
/* 132 */     FurnisherItemTile it = (blueprintI()).constructor.util.tile(tile);
/* 133 */     if (it == null)
/* 134 */       return AVAILABILITY.ROOM; 
/* 135 */     return it.availability;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\arena\grand\ArenaInstance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */