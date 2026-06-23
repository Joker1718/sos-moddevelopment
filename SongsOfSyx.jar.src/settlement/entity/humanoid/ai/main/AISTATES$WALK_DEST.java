/*     */ package settlement.entity.humanoid.ai.main;
/*     */ 
/*     */ import game.GAME;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.spirte.HSprite;
/*     */ import settlement.entity.humanoid.spirte.HSprites;
/*     */ import settlement.thing.DRAGGABLE;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.datatypes.BODY_HOLDER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.rnd.RND;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WALK_DEST
/*     */ {
/*     */   private final AISTATE state;
/*     */   private final double speed;
/*     */   
/*     */   public WALK_DEST(String key, double speed, final HSprite sprite) {
/* 475 */     this.speed = speed;
/*     */     
/* 477 */     this.state = new AISTATE(key, "walking")
/*     */       {
/*     */         public HSprite sprite(Humanoid a)
/*     */         {
/* 481 */           return sprite;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean update(Humanoid a, AIManager d, double ds) {
/* 486 */           a.speed.magnitudeAdjust(ds, 1.0D, 1.0D);
/* 487 */           float dx = d.X - a.body().cX();
/* 488 */           float dy = d.Y - a.body().cY();
/*     */           
/* 490 */           if (dx * a.speed.nX() < 0.0D || dy * a.speed.nY() < 0.0D) {
/* 491 */             a.physics.body().moveC(d.X, d.Y);
/* 492 */             return false;
/* 493 */           }  if (dx == 0.0F && dy == 0.0F) {
/* 494 */             return false;
/*     */           }
/* 496 */           d.stateTimer = (float)(d.stateTimer - ds);
/* 497 */           if (d.stateTimer <= 0.0F) {
/* 498 */             LOG.ln("" + ds + " " + ds + " " + String.valueOf(a.tc()) + " " + a.body().cX() + " " + d.X + " " + a.speed.nX() + " " + a.speed.magnitude() + " " + a.speed.magintudeMax());
/* 499 */             d.debug(a, "strange");
/*     */ 
/*     */             
/* 502 */             d.stateTimer = 10.0F;
/* 503 */             a.physics.body().moveC(d.X, d.Y);
/* 504 */             return false;
/*     */           } 
/* 506 */           return true;
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   private WALK_DEST(String key, double speed) {
/* 513 */     this(key, speed, HSprites.MOVE);
/*     */   }
/*     */   
/*     */   private WALK_DEST(String key, boolean shittycoding) {
/* 517 */     this.speed = 0.3D;
/* 518 */     this.state = new AISTATE(key, "dragging")
/*     */       {
/*     */         public HSprite sprite(Humanoid a)
/*     */         {
/* 522 */           return HSprites.DRAG;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean update(Humanoid a, AIManager d, double ds) {
/* 527 */           a.speed.magnitudeAdjust(ds, 1.0D, 1.0D);
/* 528 */           float dx = d.X - a.body().cX();
/* 529 */           float dy = d.Y - a.body().cY();
/*     */           
/* 531 */           if (dx * a.speed.nX() < 0.0D || dy * a.speed.nY() < 0.0D) {
/* 532 */             a.physics.body().moveC(d.X, d.Y);
/* 533 */             return false;
/* 534 */           }  if (dx == 0.0F && dy == 0.0F) {
/* 535 */             return false;
/*     */           }
/* 537 */           d.stateTimer = (float)(d.stateTimer - ds);
/* 538 */           if (d.stateTimer <= 0.0F) {
/* 539 */             GAME.Notify("" + a.speed.magnitude() + " " + a.speed.magnitude() + " " + String.valueOf(a.physics.tileC()) + " " + String.valueOf(d.path) + " " + a.speed.nX());
/*     */             
/* 541 */             d.stateTimer = 48.0F;
/*     */           } 
/* 543 */           DRAGGABLE c = ((DRAGGABLE.DRAGGABLE_HOLDER)DRAGGABLE.DRAGGABLE_HOLDER.all().get(d.subPathByte)).draggable(d.planObject);
/* 544 */           if (c != null) {
/* 545 */             if (c.canBeDragged())
/* 546 */               c.drag(a.speed.dir(), a.physics.body().cX(), a.physics.body().cY(), a.physics.body().width() << 1); 
/*     */           } else {
/* 548 */             d.debug(a, "draggable has mysteriously dissapeared!");
/*     */           } 
/*     */ 
/*     */           
/* 552 */           return true;
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean cTileNeeds(Humanoid a, AIManager d) {
/* 559 */     int x2 = (a.physics.tileC().x() << 6) + 32;
/* 560 */     int y2 = (a.physics.tileC().y() << 6) + 32;
/*     */     
/* 562 */     if (x2 != a.physics.body().cX() || y2 != a.physics.body().cY()) {
/* 563 */       return true;
/*     */     }
/*     */     
/* 566 */     return false;
/*     */   }
/*     */   
/*     */   public AISTATE cTile(Humanoid a, AIManager d) {
/* 570 */     int x2 = (a.physics.tileC().x() << 6) + 32;
/* 571 */     int y2 = (a.physics.tileC().y() << 6) + 32;
/* 572 */     return free(a, d, x2, y2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AISTATE path(Humanoid a, AIManager d) {
/* 597 */     int x2 = d.path.getSettCX();
/* 598 */     int y2 = d.path.getSettCY();
/*     */     
/* 600 */     if (x2 == a.physics.body().cX() && y2 == a.physics.body().cY()) {
/* 601 */       return free(a, d, a.physics.body().cX(), a.physics.body().cY());
/*     */     }
/* 603 */     if (a.physics.tileC().isSameAs((COORDINATE)d.path) && a.physics.isWithinTile()) {
/* 604 */       return free(a, d, a.physics.body().cX(), a.physics.body().cY());
/*     */     }
/*     */     
/* 607 */     a.speed.turn2((BODY_HOLDER)a, x2, y2);
/* 608 */     double dy = Math.max(
/* 609 */         a.body().y2() + 2 - (d.path.y() + 1) * 64, 
/* 610 */         d.path.y() * 64 - a.body().y1() - 2) / 
/* 611 */       Math.abs(a.speed.nY());
/* 612 */     double dx = Math.max(
/* 613 */         a.body().x2() + 2 - (d.path.x() + 1) * 64, 
/* 614 */         d.path.x() * 64 - a.body().x1() - 2) / 
/* 615 */       Math.abs(a.speed.nX());
/*     */     
/* 617 */     if (dx > dy) {
/* 618 */       x2 = (int)(a.physics.body().cX() + a.speed.nX() * dx);
/* 619 */       y2 = (int)(a.physics.body().cY() + a.speed.nY() * dx);
/*     */     } else {
/* 621 */       x2 = (int)(a.physics.body().cX() + a.speed.nX() * dy);
/* 622 */       y2 = (int)(a.physics.body().cY() + a.speed.nY() * dy);
/*     */     } 
/* 624 */     d.X = x2;
/* 625 */     d.Y = y2;
/* 626 */     a.speed.turn2((BODY_HOLDER)a, x2, y2);
/* 627 */     a.speed.magnitudeTargetSet(this.speed + RND.rFloat(0.05D));
/* 628 */     d.stateTimer = 48.0F;
/* 629 */     return this.state;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AISTATE edge(Humanoid a, AIManager d, DIR dir) {
/* 637 */     int dd = (64 - a.body().width() - 1) / 2;
/*     */     
/* 639 */     int x2 = a.physics.tileC().x() * 64 + 32 + dir.x() * dd;
/* 640 */     int y2 = a.physics.tileC().y() * 64 + 32 + dir.y() * dd;
/*     */     
/* 642 */     if (x2 == a.physics.body().cX() && y2 == a.physics.body().cY()) {
/* 643 */       return free(a, d, a.physics.body().cX(), a.physics.body().cY());
/*     */     }
/* 645 */     if (!a.physics.isWithinTile()) {
/* 646 */       return cTile(a, d);
/*     */     }
/*     */     
/* 649 */     free(a, d, x2, y2);
/* 650 */     a.speed.magnitudeTargetSet(0.2D);
/* 651 */     d.stateTimer = 48.0F;
/* 652 */     return this.state;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AISTATE moveToEdge(Humanoid a, AIManager d, DIR dir) {
/* 660 */     int x2 = a.tc().x() * 64 + 32;
/* 661 */     int y2 = a.tc().y() * 64 + 32;
/* 662 */     int dd = (64 - a.body().width() - 2) / 2;
/* 663 */     x2 += dir.x() * dd;
/* 664 */     y2 += dir.y() * dd;
/*     */     
/* 666 */     return free(a, d, x2, y2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AISTATE dirTile(Humanoid a, AIManager d, DIR dir) {
/* 673 */     int x2 = (a.physics.tileC().x() << 6) + 32;
/* 674 */     int y2 = (a.physics.tileC().y() << 6) + 32;
/* 675 */     x2 += dir.x() * 64;
/* 676 */     y2 += dir.y() * 64;
/* 677 */     return free(a, d, x2, y2);
/*     */   }
/*     */   
/*     */   public AISTATE free(Humanoid a, AIManager d, int x2, int y2) {
/* 681 */     d.X = x2;
/* 682 */     d.Y = y2;
/* 683 */     if (x2 != a.physics.body().cX() || y2 != a.physics.body().cY()) {
/* 684 */       a.speed.turn2((BODY_HOLDER)a, x2, y2).magnitudeTargetSet(this.speed + RND.rFloat(0.05D));
/*     */     }
/*     */     else {
/*     */       
/* 688 */       a.speed.magnitudeTargetSet(0.0D);
/* 689 */       a.speed.magnitudeInit(0.0D);
/*     */     } 
/* 691 */     d.stateTimer = 48.0F;
/* 692 */     return this.state;
/*     */   }
/*     */   
/*     */   public AISTATE tile(Humanoid a, AIManager d, int tx, int ty) {
/* 696 */     int x2 = (tx << 6) + 32;
/* 697 */     int y2 = (ty << 6) + 32;
/* 698 */     d.X = x2;
/* 699 */     d.Y = y2;
/* 700 */     if (x2 != a.physics.body().cX() || y2 != a.physics.body().cY()) {
/* 701 */       a.speed.turn2((BODY_HOLDER)a, x2, y2).magnitudeTargetSet(this.speed + RND.rFloat(0.05D));
/*     */     } else {
/*     */       
/* 704 */       a.speed.magnitudeTargetSet(0.0D);
/* 705 */       a.speed.magnitudeInit(0.0D);
/*     */     } 
/* 707 */     d.stateTimer = 48.0F;
/* 708 */     return this.state;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\main\AISTATES$WALK_DEST.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */