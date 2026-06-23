/*     */ package settlement.room.infra.logistics;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.GUTIL;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GButt;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   extends GButt.ButtPanel
/*     */ {
/*     */   null(SPRITE $anonymous0) {
/*  82 */     super($anonymous0);
/*     */   }
/*     */   protected void clickA() {
/*  85 */     GUTIL.flooder().init(this);
/*  86 */     GUTIL.flooder().pushSloppy(((RoomInstance)room.get()).mX(), ((RoomInstance)room.get()).mY(), 0.0D);
/*  87 */     while (GUTIL.flooder().hasMore()) {
/*  88 */       PathTile t = GUTIL.flooder().pollSmallest();
/*     */       
/*  90 */       Room r = (Room)(SETT.ROOMS()).map.get((COORDINATE)t);
/*  91 */       if (r != null && r != source.get() && r.mX(t.x(), t.y()) == t.x() && r.mY(t.x(), t.y()) == t.y() && 
/*  92 */         r instanceof MoveJob.ROOM_MOVE_SOURCE) {
/*  93 */         MoveJob.ROOM_MOVE_SOURCE ss = (MoveJob.ROOM_MOVE_SOURCE)r;
/*  94 */         if (ss.moveCapacity().has(((MoveOrderPull.MoveOrderPullInstance)source.get()).moveOrderPullAccepted())) {
/*  95 */           for (int ii = 0; ii < (((MoveOrderPull.MoveOrderPullInstance)source.get()).moveOrdersPull()).length; ii++) {
/*  96 */             MoveOrderPull o = ((MoveOrderPull.MoveOrderPullInstance)source.get()).moveOrdersPull()[ii];
/*  97 */             if (o == null || o.source() == null || o.source() == ss) {
/*  98 */               ((MoveOrderPull.MoveOrderPullInstance)source.get()).moveOrdersPull()[ii] = new MoveOrderPull((RoomInstance)r, ((MoveOrderPull.MoveOrderPullInstance)source.get()).moveOrderPullAccepted());
/*  99 */               (((MoveOrderPull.MoveOrderPullInstance)source.get()).moveOrdersPull()[ii]).pullLimit = 0;
/*     */               
/*     */               break;
/*     */             } 
/*     */           } 
/* 104 */           GUTIL.flooder().done();
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 109 */       for (DIR d : DIR.ALL) {
/* 110 */         if (SETT.IN_BOUNDS((COORDINATE)t, d) && (SETT.PATH()).coster.player.getCost(t.x(), t.y(), t.x() + d.x(), t.y() + d.y()) > 0.0D) {
/* 111 */           GUTIL.flooder().pushSmaller(t.x() + d.x(), t.y() + d.y(), t.getValue() + d.tileDistance());
/*     */         }
/*     */       } 
/*     */     } 
/* 115 */     GUTIL.flooder().done();
/* 116 */     super.clickA();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void renAction() {
/* 121 */     activeSet(true); byte b; int i;
/*     */     MoveOrderPull[] arrayOfMoveOrderPull;
/* 123 */     for (i = (arrayOfMoveOrderPull = ((MoveOrderPull.MoveOrderPullInstance)source.get()).moveOrdersPull()).length, b = 0; b < i; ) { MoveOrderPull o = arrayOfMoveOrderPull[b];
/* 124 */       if (o == null || o.source() == null) {
/*     */         return;
/*     */       }
/*     */       b++; }
/*     */     
/* 129 */     activeSet(false);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\logistics\MoveOrderPullUI$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */