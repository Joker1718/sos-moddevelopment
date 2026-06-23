/*     */ package settlement.room.infra.logistics;
/*     */ 
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import java.io.Serializable;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.TILE_STORAGE;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import util.text.D;
/*     */ 
/*     */ public final class MoveOrderPush
/*     */   implements Serializable
/*     */ {
/*  18 */   private static CharSequence ¤¤RoomInvalid = "The destination room is invalid.";
/*  19 */   private static CharSequence ¤¤ResNone = "No resource have been specified.";
/*  20 */   private static CharSequence ¤¤ResBad = "The resources specified can not be accepted by the destination room.";
/*  21 */   private static CharSequence ¤¤ResANone = "There are not enough resources stocked to deliver.";
/*  22 */   private static CharSequence ¤¤ResANoneDest = "The destination does not have the capacity to accept a delivery.";
/*  23 */   private static CharSequence ¤¤limit = "The destination room's current storage exceeds the current push limit";
/*     */ 
/*     */   
/*     */   static {
/*  27 */     D.ts(MoveOrderPush.class);
/*     */   }
/*     */   
/*  30 */   private final Coo coo = new Coo();
/*  31 */   public byte cooldown = 0;
/*     */   private short ox;
/*  33 */   public byte limit = 80;
/*     */   
/*     */   private short oy;
/*     */   
/*     */   private static final long serialVersionUID = 1L;
/*     */   
/*     */   public MoveOrderPush(RoomInstance dest) {
/*  40 */     this.coo.set(dest.mX(), dest.mY());
/*     */   }
/*     */   
/*     */   public CharSequence problem(MoveOrderPushInstance ins) {
/*  44 */     MoveJob.ROOM_MOVE_DEST dest = dest();
/*  45 */     return problem(dest, ins);
/*     */   }
/*     */   
/*     */   public static CharSequence problem(MoveJob.ROOM_MOVE_DEST dest, MoveOrderPushInstance ins) {
/*  49 */     if (dest == null)
/*  50 */       return ¤¤RoomInvalid; 
/*  51 */     if (ins.moveOrderPushCapacity().isClear())
/*  52 */       return ¤¤ResNone; 
/*  53 */     if (!ins.moveOrderPushCapacity().has(dest.destSpaceMask()))
/*  54 */       return ¤¤ResBad; 
/*  55 */     return null;
/*     */   }
/*     */   
/*     */   public CharSequence warning(MoveOrderPushInstance ins) {
/*  59 */     CharSequence p = problem(ins);
/*  60 */     if (p != null)
/*  61 */       return p; 
/*  62 */     MoveJob.ROOM_MOVE_DEST dest = dest();
/*     */     
/*  64 */     RBIT acc = ins.moveOrderPushAvailable();
/*  65 */     if (!acc.has(dest.destSpaceMask())) {
/*  66 */       return ¤¤ResANone;
/*     */     }
/*     */     
/*  69 */     boolean h = false;
/*  70 */     for (RESOURCE r : RESOURCES.ALL()) {
/*  71 */       if (acc.has(r) && this.limit > dest.storedD(r) * 100.0D) {
/*  72 */         h = true;
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/*  77 */     if (!h) {
/*  78 */       return ¤¤limit;
/*     */     }
/*     */     
/*  81 */     TILE_STORAGE t = dest.destCrate(acc, ins.moveMinAmount(), this.ox, this.oy);
/*  82 */     if (t == null) {
/*  83 */       return ¤¤ResANoneDest;
/*     */     }
/*  85 */     this.ox = (short)t.x();
/*  86 */     this.oy = (short)t.y();
/*     */ 
/*     */ 
/*     */     
/*  90 */     return null;
/*     */   }
/*     */   
/*     */   public void destSet(RoomInstance dest) {
/*  94 */     this.coo.set(dest.mX(), dest.mY());
/*     */   }
/*     */   
/*     */   public MoveJob.ROOM_MOVE_DEST dest() {
/*  98 */     Room r = (Room)(SETT.ROOMS()).map.get((COORDINATE)this.coo);
/*  99 */     if (r != null && r instanceof MoveJob.ROOM_MOVE_DEST) {
/* 100 */       return (MoveJob.ROOM_MOVE_DEST)r;
/*     */     }
/* 102 */     return null;
/*     */   }
/*     */   
/*     */   public RoomInstance destI() {
/* 106 */     Room r = (Room)(SETT.ROOMS()).map.get((COORDINATE)this.coo);
/* 107 */     if (r != null && r instanceof MoveJob.ROOM_MOVE_DEST) {
/* 108 */       return (RoomInstance)r;
/*     */     }
/* 110 */     return null;
/*     */   }
/*     */   
/*     */   public static interface MoveOrderPushInstance {
/*     */     MoveOrderPush[] moveOrdersPush();
/*     */     
/*     */     RBIT moveOrderPushCapacity();
/*     */     
/*     */     RBIT moveOrderPushAvailable();
/*     */     
/*     */     int moveMinAmount();
/*     */     
/*     */     int moveMaxRadius();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\logistics\MoveOrderPush.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */