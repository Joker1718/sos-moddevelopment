/*     */ package settlement.room.service.module;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.path.finders.SFinderRoomService;
/*     */ import settlement.room.main.ROOMA;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.util.MATH;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayCooShort;
/*     */ import util.GUTIL;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class ROOM_ACTIVITY
/*     */ {
/*  22 */   public static final double WORK_ENDSD = 2.0D / TIME.hoursPerDay();
/*  23 */   public static final double WORK_STARTSD = MATH.mod(3 - TIME.workHours(), TIME.hoursPerDay()) / TIME.hoursPerDay();
/*     */   
/*  25 */   private static final ArrayCooShort spots = new ArrayCooShort(700);
/*     */   
/*     */   public boolean is(int sx, int sy) {
/*  28 */     return (finder().get(sx, sy) != null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  33 */   private Coo coo = new Coo();
/*     */   
/*     */   public COORDINATE lookAt(int sx, int sy) {
/*  36 */     this.coo.set((sx * 64 + 32), (sy * 64 + 32));
/*  37 */     return (COORDINATE)this.coo;
/*     */   }
/*     */   public abstract SFinderRoomService finder();
/*     */   public boolean shouldCheer(int sx, int sy) {
/*  41 */     return false;
/*     */   }
/*     */   
/*     */   public boolean shouldBoo(int sx, int sy) {
/*  45 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract boolean isActive(int paramInt1, int paramInt2);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public COORDINATE getDestination(COORDINATE roomT) {
/*  57 */     ROOMA r = (ROOMA)(SETT.ROOMS()).map.rooma.get(roomT);
/*  58 */     GUTIL.flooder().init(this);
/*  59 */     spots.set(0);
/*  60 */     for (COORDINATE c : r.body()) {
/*  61 */       if (r.is(c)) {
/*  62 */         GUTIL.flooder().pushSloppy(c.x(), c.y(), 7.0D);
/*     */       }
/*     */     } 
/*     */     
/*  66 */     while (GUTIL.flooder().hasMore()) {
/*  67 */       PathTile t = GUTIL.flooder().pollGreatest();
/*  68 */       if (isSpot(t.x(), t.y())) {
/*  69 */         spots.get().set(t.x(), t.y());
/*  70 */         spots.inc();
/*     */       } 
/*  72 */       if (t.getValue() <= 0.0F) {
/*     */         continue;
/*     */       }
/*  75 */       for (int di = 0; di < DIR.ALL.size(); di++) {
/*  76 */         DIR dd = (DIR)DIR.ALL.get(di);
/*  77 */         int dx = t.x() + dd.x();
/*  78 */         int dy = t.y() + dd.y();
/*  79 */         double c = (SETT.PATH()).coster.player.getCost(t.x(), t.y(), dx, dy);
/*  80 */         if (c > 0.0D) {
/*  81 */           DIR old = dd;
/*  82 */           if (t.getParent() != null)
/*  83 */             old = DIR.get((COORDINATE)t.getParent(), (COORDINATE)t); 
/*  84 */           if (old != dd)
/*  85 */             c *= 2.0D; 
/*  86 */           c *= dd.tileDistance();
/*  87 */           GUTIL.flooder().pushGreater(dx, dy, t.getValue() - c);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/*  92 */     GUTIL.flooder().done();
/*     */     
/*  94 */     int max = spots.getI();
/*     */     
/*  96 */     if (max == 0) {
/*  97 */       return roomT;
/*     */     }
/*  99 */     return (COORDINATE)spots.set(RND.rInt(max));
/*     */   }
/*     */   
/*     */   protected boolean isSpot(int tx, int ty) {
/* 103 */     if (!SETT.IN_BOUNDS(tx, ty))
/* 104 */       return false; 
/* 105 */     if ((SETT.ROOMS()).map.is(tx, ty))
/* 106 */       return false; 
/* 107 */     AVAILABILITY av = (SETT.PATH()).availability.get(tx, ty);
/* 108 */     if (av.player >= 0.0D && av.player < 2.0D && av.from == 0.0D) {
/* 109 */       return true;
/*     */     }
/* 111 */     return false;
/*     */   }
/*     */   
/*     */   public static interface ROOM_ACTIVITY_HASER {
/*     */     ROOM_ACTIVITY spec();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\module\ROOM_ACTIVITY.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */