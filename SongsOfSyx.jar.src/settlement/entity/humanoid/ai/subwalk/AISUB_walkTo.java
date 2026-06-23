/*     */ package settlement.entity.humanoid.ai.subwalk;
/*     */ 
/*     */ import game.GAME;
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.resources.ResGroup;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AISTATE;
/*     */ import settlement.entity.humanoid.ai.main.AISTATES;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.FINDABLE;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.path.finders.SFinderFindable;
/*     */ import settlement.path.finders.SFinderRoomService;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.service.module.RoomService;
/*     */ import settlement.thing.DRAGGABLE;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.rnd.RND;
/*     */ import util.GUTIL;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class AISUB_walkTo
/*     */ {
/*     */   public AISUB.AISubActivation pathRun(Humanoid a, AIManager d) {
/*  36 */     return this.run.activate(a, d);
/*     */   }
/*     */   
/*     */   public AISUB.AISubActivation path(Humanoid a, AIManager d) {
/*  40 */     return this.vanilla.activate(a, d);
/*     */   }
/*     */   
/*     */   public AISUB.AISubActivation pathFull(Humanoid a, AIManager d) {
/*  44 */     return this.vanilla_included.activate(a, d);
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
/*     */   public AISUB.AISubActivation room(Humanoid a, AIManager d, int rx, int ry) {
/*  57 */     Room room = (SETT.ROOMS()).map.get(rx, ry);
/*     */     
/*  59 */     int w = room.width(rx, ry);
/*  60 */     int h = room.height(rx, ry);
/*     */     
/*  62 */     int r = (w > h) ? w : h;
/*  63 */     if (r <= 2) {
/*  64 */       COORDINATE c = (SETT.PATH()).finders.arround.find(rx, ry, 10.0D, (10 + RND.rInt(10)));
/*  65 */       if (c != null && 
/*  66 */         d.path.request(a.physics.tileC(), c.x(), c.y())) {
/*  67 */         return this.vanilla.activate(a, d);
/*     */       }
/*  69 */       return null;
/*     */     } 
/*     */     
/*  72 */     if ((SETT.PATH()).comps.superComp.get(a.tc()) != (SETT.PATH()).comps.superComp.get(room.mX(rx, ry), room.mY(rx, ry))) {
/*  73 */       return null;
/*     */     }
/*     */     
/*  76 */     int x1 = room.x1(rx, ry);
/*  77 */     int y1 = room.y1(rx, ry);
/*  78 */     int x2 = x1 + w;
/*  79 */     int y2 = y1 + h;
/*     */     
/*  81 */     int x = x1 + RND.rInt(w);
/*  82 */     int y = y1 + RND.rInt(h);
/*     */     
/*  84 */     int backupX = -1;
/*  85 */     int backupY = -1;
/*     */     
/*  87 */     for (int i = w * h; i >= 0; i--) {
/*     */       
/*  89 */       if (x >= x2) {
/*  90 */         y++;
/*  91 */         x = x1;
/*  92 */         if (y >= y2) {
/*  93 */           y = y1;
/*     */         }
/*     */       } 
/*     */       
/*  97 */       if (room.isSame(rx, ry, x, y)) {
/*  98 */         AVAILABILITY av = (SETT.PATH()).availability.get(x, y);
/*  99 */         if (av.player >= 0.0D && av.player < 2.0D && av.from == 0.0D) {
/* 100 */           d.path.requestFull(a.physics.tileC(), x, y);
/* 101 */           if (d.path.isSuccessful())
/* 102 */             return this.vanilla.activate(a, d); 
/* 103 */           GAME.Notify("couldn't find path from: " + String.valueOf(a.physics.tileC()) + " to" + x + " " + y); break;
/*     */         } 
/* 105 */         if (backupX == -1 && av.player >= 0.0D) {
/* 106 */           backupX = x;
/* 107 */           backupY = y;
/*     */         } 
/*     */       } 
/*     */       
/* 111 */       x++;
/*     */     } 
/*     */     
/* 114 */     if (backupX != -1) {
/* 115 */       d.path.requestFull(a.physics.tileC(), backupX, backupY);
/* 116 */       if (d.path.isSuccessful())
/* 117 */         return this.vanilla.activate(a, d); 
/* 118 */       GAME.Notify("couldn't find path from: " + String.valueOf(a.physics.tileC()) + " to" + backupX + " " + backupY);
/*     */     } 
/*     */     
/* 121 */     GAME.Notify("Couldn't find place in room " + rx + " " + ry + " " + w + " " + h + " " + r + " " + String.valueOf(room) + " ");
/* 122 */     return null;
/*     */   }
/*     */   
/*     */   public AISUB.AISubActivation room(Humanoid a, AIManager d, RoomInstance ins) {
/* 126 */     return room(a, d, ins.mX(), ins.mY());
/*     */   }
/*     */   
/*     */   public AISUB.AISubActivation around(Humanoid a, AIManager d, int tx, int ty) {
/* 130 */     COORDINATE c = (SETT.PATH()).finders.arround.find(tx, ty, 10.0D, (10 + RND.rInt(10)));
/* 131 */     if (c != null && 
/* 132 */       d.path.request(a.physics.tileC(), c.x(), c.y())) {
/* 133 */       return this.vanilla.activate(a, d);
/*     */     }
/* 135 */     return null;
/*     */   }
/*     */   
/*     */   public AISUB.AISubActivation around(Humanoid a, AIManager d, int tx, int ty, int mindistance, int maxDistance) {
/* 139 */     COORDINATE c = (SETT.PATH()).finders.arround.find(tx, ty, mindistance, maxDistance);
/* 140 */     if (c != null && 
/* 141 */       d.path.request(a.physics.tileC(), c.x(), c.y())) {
/* 142 */       return this.vanilla.activate(a, d);
/*     */     }
/* 144 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   AISUB.AISubActivation insideRoom(Humanoid a, AIManager d) {
/* 154 */     Room room = (Room)(SETT.ROOMS()).map.get(a.physics.tileC());
/* 155 */     int rx = room.mX(a.physics.tileC().x(), a.physics.tileC().y());
/* 156 */     int ry = room.mY(a.physics.tileC().x(), a.physics.tileC().y());
/* 157 */     int w = room.width(rx, ry);
/* 158 */     int h = room.height(rx, ry);
/*     */     
/* 160 */     int r = (w > h) ? w : h;
/* 161 */     if (r <= 2) {
/* 162 */       COORDINATE c = (SETT.PATH()).finders.arround.find(rx, ry, 10.0D, (10 + RND.rInt(10)));
/* 163 */       if (c != null && 
/* 164 */         d.path.request(a.physics.tileC(), c.x(), c.y())) {
/* 165 */         return this.vanilla.activate(a, d);
/*     */       }
/* 167 */       return null;
/*     */     } 
/*     */     
/* 170 */     int sx = a.physics.tileC().x() + RND.rInt(w);
/* 171 */     int sy = a.physics.tileC().y() + RND.rInt(h);
/*     */     
/* 173 */     int i = 0;
/*     */     
/* 175 */     while (GUTIL.circle().radius(i++) <= r) {
/* 176 */       COORDINATE c = GUTIL.circle().get(i);
/* 177 */       int x = sx + c.x();
/* 178 */       int y = sy + c.y();
/* 179 */       if (room.isSame(rx, ry, x, y) && (SETT.PATH()).cost.get(x, y) > 0.0D) {
/* 180 */         d.path.requestFull(a.physics.tileC(), x, y);
/* 181 */         if (d.path.isSuccessful()) {
/* 182 */           return this.vanilla.activate(a, d);
/*     */         }
/*     */         break;
/*     */       } 
/*     */     } 
/* 187 */     GAME.Notify("Couldn't find place in room " + rx + " " + ry);
/* 188 */     return null;
/*     */   }
/*     */   
/*     */   public AISUB.AISubActivation coo(Humanoid a, AIManager d, int dx, int dy) {
/* 192 */     d.path.request(a.physics.tileC(), dx, dy);
/* 193 */     if (d.path.isSuccessful())
/* 194 */       return this.vanilla.activate(a, d); 
/* 195 */     return null;
/*     */   }
/*     */   
/*     */   public AISUB.AISubActivation coo(Humanoid a, AIManager d, COORDINATE dest) {
/* 199 */     return coo(a, d, dest.x(), dest.y());
/*     */   }
/*     */ 
/*     */   
/*     */   public AISUB.AISubActivation drag(Humanoid a, AIManager d, DRAGGABLE.DRAGGABLE_HOLDER h, int index, int dx, int dy) {
/* 204 */     d.planObject = index;
/* 205 */     d.subPathByte = h.index;
/*     */     
/* 207 */     if (h.draggable(d.planObject) == null) {
/* 208 */       d.debug(a, "Draggable gone! ");
/* 209 */       return null;
/*     */     } 
/*     */     
/* 212 */     if (!h.draggable(d.planObject).canBeDragged()) {
/* 213 */       return null;
/*     */     }
/*     */     
/* 216 */     d.path.request(a.physics.tileC(), dx, dy);
/* 217 */     if (d.path.isSuccessful())
/* 218 */       return this.drag.activate(a, d); 
/* 219 */     return null;
/*     */   }
/*     */   
/*     */   public AISUB.AISubActivation drag(Humanoid a, AIManager d, DRAGGABLE.DRAGGABLE_HOLDER h, int index, COORDINATE dest) {
/* 223 */     return drag(a, d, h, index, dest.x(), dest.y());
/*     */   }
/*     */   
/*     */   public AISUB.AISubActivation cooFull(Humanoid a, AIManager d, COORDINATE dest) {
/* 227 */     d.path.requestFull(a.physics.tileC(), dest);
/* 228 */     if (d.path.isSuccessful())
/* 229 */       return this.vanilla_included.activate(a, d); 
/* 230 */     return null;
/*     */   }
/*     */   
/*     */   public AISUB.AISubActivation cooFull(Humanoid a, AIManager d, int dx, int dy) {
/* 234 */     d.path.requestFull(a.physics.tileC(), dx, dy);
/* 235 */     if (d.path.isSuccessful())
/* 236 */       return this.vanilla_included.activate(a, d); 
/* 237 */     return null;
/*     */   }
/*     */   
/*     */   public AISUB.AISubActivation resource(Humanoid a, AIManager d, ResGroup<?> r) {
/* 241 */     return resource(a, d, r.mask, 250);
/*     */   }
/*     */   
/*     */   public AISUB.AISubActivation resource(Humanoid a, AIManager d, RBIT resBits, int maxDist) {
/* 245 */     RESOURCE res = (SETT.PATH()).finders.resource.normal.reserve(a.physics.tileC(), resBits, d.path, maxDist);
/* 246 */     if (res == null) {
/* 247 */       d.subPathByte = -1;
/* 248 */       return null;
/*     */     } 
/*     */     
/* 251 */     d.subPathByte = res.bIndex();
/*     */     
/* 253 */     return this.resource.activate(a, d);
/*     */   }
/*     */   
/*     */   public AISUB.AISubActivation resource(Humanoid a, AIManager d, RBIT resBits) {
/* 257 */     return resource(a, d, resBits, 250);
/*     */   }
/*     */   
/*     */   public AISUB.AISubActivation resource(Humanoid a, AIManager d, RESOURCE r, int maxDistance) {
/* 261 */     return resource(a, d, r.bit, maxDistance);
/*     */   }
/*     */   
/*     */   public AISUB.AISubActivation resource(Humanoid a, AIManager d, RESOURCE r) {
/* 265 */     return resource(a, d, r.bit, 250);
/*     */   }
/*     */   
/*     */   public AISUB.AISubActivation resourceAlreadyReserved(Humanoid a, AIManager d, RESOURCE r) {
/* 269 */     d.subPathByte = r.bIndex();
/* 270 */     return this.resource.activate(a, d);
/*     */   }
/*     */   
/*     */   public RESOURCE targetResource(Humanoid a, AIManager d) {
/* 274 */     return (RESOURCE)RESOURCES.ALL().get(d.subPathByte);
/*     */   }
/*     */   
/*     */   public AISUB.AISubActivation deposit(Humanoid a, AIManager d, RESOURCE r) {
/* 278 */     return deposit(a, d, r, 2147483647);
/*     */   }
/*     */ 
/*     */   
/*     */   public AISUB.AISubActivation deposit(Humanoid a, AIManager d, RESOURCE r, int maxTiles) {
/* 283 */     if ((SETT.PATH()).finders.storage.reserve(a.physics.tileC(), r, d.path, maxTiles)) {
/* 284 */       d.subPathByte = r.bIndex();
/* 285 */       d.resourceCarriedSet(r);
/* 286 */       return this.storage.activate(a, d);
/*     */     } 
/* 288 */     (SETT.THINGS()).resources.create(a.physics.tileC(), r, 1);
/* 289 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AISUB.AISubActivation depositInited(Humanoid a, AIManager d, RESOURCE r) {
/* 296 */     d.subPathByte = r.bIndex();
/* 297 */     d.resourceCarriedSet(r);
/* 298 */     return this.storage.activate(a, d);
/*     */   }
/*     */ 
/*     */   
/*     */   public AISUB.AISubActivation service(Humanoid a, AIManager d, RoomService r) {
/* 303 */     return service(a, d, (SFinderFindable)r.finder, r.radius);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public AISUB.AISubActivation service(Humanoid a, AIManager d, SFinderFindable r, int distance) {
/* 309 */     if (!r.reserve(a.physics.tileC(), d.path, distance)) {
/* 310 */       return null;
/*     */     }
/* 312 */     d.subPathByte = r.index;
/* 313 */     return this.service.activate(a, d);
/*     */   }
/*     */ 
/*     */   
/*     */   AISUB.AISubActivation service(Humanoid a, AIManager d, SFinderFindable r, COORDINATE c) {
/* 318 */     FINDABLE f = r.getReservable(c.x(), c.y());
/* 319 */     if (f == null)
/* 320 */       return null; 
/* 321 */     d.subPathByte = r.index;
/* 322 */     d.path.request(a.physics.tileC().x(), a.physics.tileC().y(), c);
/* 323 */     if (!d.path.isSuccessful())
/* 324 */       return null; 
/* 325 */     f.findableReserve();
/*     */     
/* 327 */     return this.service.activate(a, d);
/*     */   }
/*     */   
/*     */   public AISUB.AISubActivation serviceInclude(Humanoid a, AIManager d, RoomService r) {
/* 331 */     return serviceInclude(a, d, (SFinderFindable)r.finder, r.radius);
/*     */   }
/*     */   
/*     */   public AISUB.AISubActivation serviceInclude(Humanoid a, AIManager d, RoomService r, int dist) {
/* 335 */     return serviceInclude(a, d, (SFinderFindable)r.finder, dist);
/*     */   }
/*     */   
/*     */   public AISUB.AISubActivation serviceInclude(Humanoid a, AIManager d, SFinderFindable r, int dist) {
/* 339 */     d.subPathByte = r.index;
/* 340 */     if (!r.reserve(a.physics.tileC(), d.path, dist)) {
/* 341 */       return null;
/*     */     }
/*     */     
/* 344 */     return this.serviceInclude.activate(a, d);
/*     */   }
/*     */ 
/*     */   
/*     */   public AISUB.AISubActivation serviceMax(Humanoid a, AIManager d, SFinderFindable r) {
/* 349 */     d.subPathByte = r.index;
/* 350 */     if (!r.reserve(a.physics.tileC(), d.path, 2147483647)) {
/* 351 */       GAME.Notify("oh no!");
/* 352 */       return null;
/*     */     } 
/*     */     
/* 355 */     return this.service.activate(a, d);
/*     */   }
/*     */ 
/*     */   
/*     */   public AISUB.AISubActivation follow(Humanoid a, AIManager d, ENTITY target, boolean run, byte trials) {
/* 360 */     if (run)
/* 361 */       return this.follow_run.activate(a, d, target, trials); 
/* 362 */     return this.follow.activate(a, d, target, trials);
/*     */   }
/*     */   
/*     */   public boolean followSucess(Humanoid a, AIManager d) {
/* 366 */     return this.follow_run.isSuccess(a, d);
/*     */   }
/*     */   
/*     */   public AISUB.AISubActivation flee(Humanoid a, AIManager d, ENTITY other) {
/* 370 */     return this.flee.activate(a, d, other);
/*     */   }
/*     */   
/*     */   public AISUB.AISubActivation run_arround_crazy(Humanoid a, AIManager d, int iterations) {
/* 374 */     return this.flee.activate(a, d, iterations);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 379 */   private final SubFlee flee = new SubFlee();
/* 380 */   private final AISub_follow follow = new AISub_follow("walk2Follow", (AI.STATES()).WALK2, "following");
/* 381 */   private final AISub_follow follow_run = new AISub_follow("walk2Chase", (AI.STATES()).RUN2, "chasing");
/*     */ 
/*     */ 
/*     */   
/* 385 */   private final AISUB vanilla = (AISUB)new PathWalker("walkPath", "walking along path")
/*     */     {
/*     */       public void abort(Humanoid a, AIManager d) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void arrive(Humanoid a, AIManager d) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public boolean hasFailed(Humanoid a, AIManager d) {
/* 400 */         return false;
/*     */       }
/*     */     };
/*     */   
/* 404 */   private final AISUB vanilla_included = (AISUB)new PathWalker("walkVanilla", "walking along path")
/*     */     {
/*     */       public AISTATE init(Humanoid a, AIManager d)
/*     */       {
/* 408 */         if (a.tc().isSameAs(d.path.destX(), d.path.destY()) && a.physics.isWithinTile())
/* 409 */           return this.wait.set(a, d); 
/* 410 */         return super.init(a, d);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void abort(Humanoid a, AIManager d) {}
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void arrive(Humanoid a, AIManager d) {}
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public boolean hasFailed(Humanoid a, AIManager d) {
/* 427 */         return false;
/*     */       }
/*     */       
/* 430 */       private final AISUB.Resumable.Resumer last = new AISUB.Resumable.Resumer(this)
/*     */         {
/*     */           protected AISTATE setAction(Humanoid a, AIManager d)
/*     */           {
/* 434 */             return (AI.STATES()).WALK2.free(a, d, d.path.destX() * 64 + 32, d.path.destY() * 64 + 32);
/*     */           }
/*     */ 
/*     */           
/*     */           protected AISTATE res(Humanoid a, AIManager d) {
/* 439 */             return AISUB_walkTo.null.this.wait.set(a, d);
/*     */           }
/*     */         };
/*     */ 
/*     */       
/*     */       protected AISTATE setLast(Humanoid a, AIManager d) {
/* 445 */         return this.last.set(a, d);
/*     */       }
/*     */     };
/*     */   
/* 449 */   private final AISUB drag = (AISUB)new PathWalker("walkDrag", (AI.STATES()).DRAG, "dragging something")
/*     */     {
/*     */       public void abort(Humanoid a, AIManager d) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void arrive(Humanoid a, AIManager d) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public boolean hasFailed(Humanoid a, AIManager d) {
/* 464 */         DRAGGABLE c = ((DRAGGABLE.DRAGGABLE_HOLDER)DRAGGABLE.DRAGGABLE_HOLDER.all().get(d.subPathByte)).draggable(d.planObject);
/* 465 */         boolean ret = !(c != null && c.canBeDragged());
/*     */         
/* 467 */         return ret;
/*     */       }
/*     */     };
/*     */   
/* 471 */   private final AISUB run = (AISUB)new PathWalker("walkRun", (AI.STATES()).RUN2, "running")
/*     */     {
/*     */       public void abort(Humanoid a, AIManager d) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       protected AISTATE setLast(Humanoid a, AIManager d) {
/* 481 */         return null;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public void arrive(Humanoid a, AIManager d) {}
/*     */ 
/*     */ 
/*     */       
/*     */       public boolean hasFailed(Humanoid a, AIManager d) {
/* 491 */         return false;
/*     */       }
/*     */     };
/*     */   
/* 495 */   private AISUB resource = (AISUB)new PathWalker("walkRes", "walking to resource")
/*     */     {
/* 497 */       private final AISUB.Resumable.Resumer pickedup = new AISUB.Resumable.Resumer(this)
/*     */         {
/*     */           public AISTATE res(Humanoid a, AIManager d)
/*     */           {
/* 501 */             return null;
/*     */           }
/*     */ 
/*     */           
/*     */           public boolean success(Humanoid a, AIManager d) {
/* 506 */             return true;
/*     */           }
/*     */ 
/*     */           
/*     */           public AISTATE setAction(Humanoid a, AIManager d) {
/* 511 */             return null;
/*     */           }
/*     */           
/*     */           public void can(Humanoid a, AIManager d) {
/* 515 */             d.resourceDrop(a);
/*     */           }
/*     */         };
/*     */ 
/*     */       
/*     */       public void abort(Humanoid a, AIManager d) {
/* 521 */         (SETT.PATH()).finders.resource.unreserve((RESOURCE)RESOURCES.ALL().get(d.subPathByte), d.path.destX(), d.path.destY(), 1);
/*     */       }
/*     */ 
/*     */       
/*     */       public void arrive(Humanoid a, AIManager d) {
/* 526 */         int x = d.path.destX();
/* 527 */         int y = d.path.destY();
/* 528 */         RESOURCE r = (RESOURCE)RESOURCES.ALL().get(d.subPathByte);
/* 529 */         (SETT.PATH()).finders.resource.pickup(r, x, y, 1);
/* 530 */         d.resourceCarriedSet(r);
/* 531 */         if (r == null)
/* 532 */           d.debug(a, ((RESOURCE)RESOURCES.ALL().get(d.subPathByte)).name); 
/* 533 */         this.pickedup.set(a, d);
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean hasFailed(Humanoid a, AIManager d) {
/* 538 */         int x = d.path.destX();
/* 539 */         int y = d.path.destY();
/* 540 */         RESOURCE r = (RESOURCE)RESOURCES.ALL().get(d.subPathByte);
/* 541 */         if (!(SETT.PATH()).finders.resource.isReservedAndAvailable(r, x, y)) {
/* 542 */           return ((SETT.PATH()).finders.resource.scattered.reserveExtra(r, x, y, 1) == 0);
/*     */         }
/* 544 */         return false;
/*     */       }
/*     */     };
/*     */ 
/*     */   
/* 549 */   private AISUB storage = (AISUB)new PathWalker("walkStore", "walking to stockpile")
/*     */     {
/* 551 */       private final AISUB.Resumable.Resumer finished = new AISUB.Resumable.Resumer(this)
/*     */         {
/*     */           public AISTATE res(Humanoid a, AIManager d)
/*     */           {
/* 555 */             return null;
/*     */           }
/*     */ 
/*     */           
/*     */           public boolean success(Humanoid a, AIManager d) {
/* 560 */             return true;
/*     */           }
/*     */ 
/*     */           
/*     */           public AISTATE setAction(Humanoid a, AIManager d) {
/* 565 */             return null;
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public void can(Humanoid a, AIManager d) {}
/*     */         };
/*     */ 
/*     */       
/*     */       public void abort(Humanoid a, AIManager d) {
/* 575 */         (SETT.PATH()).finders.storage.cancelReservation(d.path.destX(), d.path.destY(), d.subPathByte);
/*     */       }
/*     */ 
/*     */       
/*     */       public void arrive(Humanoid a, AIManager d) {
/* 580 */         int x = d.path.destX();
/* 581 */         int y = d.path.destY();
/* 582 */         (SETT.PATH()).finders.storage.deposit(x, y, d.subPathByte);
/* 583 */         d.resourceCarriedSet(null);
/* 584 */         this.finished.set(a, d);
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean hasFailed(Humanoid a, AIManager d) {
/* 589 */         int x = d.path.destX();
/* 590 */         int y = d.path.destY();
/* 591 */         return !(SETT.PATH()).finders.storage.isReservedAndAvailable(x, y, d.subPathByte);
/*     */       }
/*     */     };
/*     */ 
/*     */   
/* 596 */   private AISUB service = (AISUB)new PathWalker("WalkSer", "walking to service")
/*     */     {
/*     */       public void arrive(Humanoid a, AIManager d)
/*     */       {
/* 600 */         this.finished.set(a, d);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public void abort(Humanoid a, AIManager d) {
/* 606 */         FINDABLE s = service(d);
/* 607 */         if (s != null) {
/* 608 */           s.findableReserveCancel();
/*     */         }
/*     */       }
/*     */       
/*     */       public boolean hasFailed(Humanoid a, AIManager d) {
/* 613 */         FINDABLE s = service(d);
/*     */         
/* 615 */         if (s == null || !s.findableReservedIs()) {
/* 616 */           return true;
/*     */         }
/*     */         
/* 619 */         return false;
/*     */       }
/*     */       
/*     */       private FINDABLE service(AIManager d) {
/* 623 */         int x = d.path.destX();
/* 624 */         int y = d.path.destY();
/* 625 */         SFinderFindable s = SFinderRoomService.get(d.subPathByte);
/* 626 */         if (s == null)
/* 627 */           return null; 
/* 628 */         return s.getReserved(x, y);
/*     */       }
/*     */       
/* 631 */       private final AISUB.Resumable.Resumer finished = new AISUB.Resumable.Resumer(this)
/*     */         {
/*     */           public AISTATE res(Humanoid a, AIManager d)
/*     */           {
/* 635 */             return null;
/*     */           }
/*     */ 
/*     */           
/*     */           public boolean success(Humanoid a, AIManager d) {
/* 640 */             return true;
/*     */           }
/*     */ 
/*     */           
/*     */           public AISTATE setAction(Humanoid a, AIManager d) {
/* 645 */             return null;
/*     */           }
/*     */           
/*     */           public void can(Humanoid a, AIManager d) {
/* 649 */             AISUB_walkTo.null.this.abort(a, d);
/*     */           }
/*     */         };
/*     */     };
/*     */ 
/*     */   
/* 655 */   private AISUB serviceInclude = (AISUB)new PathWalker("walkSer2", "walking to service")
/*     */     {
/* 657 */       private final AISUB.Resumable.Resumer movingLast = new AISUB.Resumable.Resumer(this)
/*     */         {
/*     */           
/*     */           public AISTATE setAction(Humanoid a, AIManager d)
/*     */           {
/* 662 */             AISTATE s = (AI.STATES()).WALK2.tile(a, d, d.path.destX(), d.path.destY());
/*     */             
/* 664 */             return s;
/*     */           }
/*     */ 
/*     */           
/*     */           public AISTATE res(Humanoid a, AIManager d) {
/* 669 */             if (!a.physics.tileC().isSameAs(d.path.destX(), d.path.destY())) {
/* 670 */               d.debug(a, "weird");
/*     */             }
/* 672 */             a.speed.magnitudeInit(0.0D);
/* 673 */             return AISUB_walkTo.null.this.wait.set(a, d);
/*     */           }
/*     */           
/*     */           public void can(Humanoid a, AIManager d) {
/* 677 */             AISUB_walkTo.null.this.abort(a, d);
/*     */           }
/*     */         };
/*     */       
/* 681 */       private final AISUB.Resumable.Resumer finished = new AISUB.Resumable.Resumer(this)
/*     */         {
/*     */           public AISTATE res(Humanoid a, AIManager d)
/*     */           {
/* 685 */             return null;
/*     */           }
/*     */ 
/*     */           
/*     */           public boolean success(Humanoid a, AIManager d) {
/* 690 */             return true;
/*     */           }
/*     */ 
/*     */           
/*     */           public AISTATE setAction(Humanoid a, AIManager d) {
/* 695 */             return null;
/*     */           }
/*     */           
/*     */           public void can(Humanoid a, AIManager d) {
/* 699 */             AISUB_walkTo.null.this.abort(a, d);
/*     */           }
/*     */         };
/*     */ 
/*     */       
/*     */       public void arrive(Humanoid a, AIManager d) {
/* 705 */         this.finished.set(a, d);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public AISTATE setLast(Humanoid a, AIManager d) {
/* 711 */         return this.movingLast.set(a, d);
/*     */       }
/*     */ 
/*     */       
/*     */       public void abort(Humanoid a, AIManager d) {
/* 716 */         FINDABLE s = service(d);
/* 717 */         if (s != null) {
/* 718 */           s.findableReserveCancel();
/*     */         }
/*     */       }
/*     */       
/*     */       public boolean hasFailed(Humanoid a, AIManager d) {
/* 723 */         FINDABLE s = service(d);
/* 724 */         if (s == null || !s.findableReservedIs()) {
/* 725 */           return true;
/*     */         }
/*     */         
/* 728 */         return false;
/*     */       }
/*     */       
/*     */       private FINDABLE service(AIManager d) {
/* 732 */         int x = d.path.destX();
/* 733 */         int y = d.path.destY();
/* 734 */         SFinderFindable s = SFinderRoomService.get(d.subPathByte);
/* 735 */         if (s == null) {
/* 736 */           return null;
/*     */         }
/*     */         
/* 739 */         return s.getReserved(x, y);
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*     */   public boolean isWalking(AIManager a) {
/* 745 */     return a.plansub() instanceof PathWalker;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\subwalk\AISUB_walkTo.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */