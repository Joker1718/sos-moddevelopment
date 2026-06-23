/*     */ package settlement.room.main.placement;
/*     */ import game.GAME;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.sets.IntegerStack;
/*     */ 
/*     */ final class UtilHistory {
/*     */   private static final int historyAmount = 1024;
/*  11 */   private HistoryI[] histories = new HistoryI[1024];
/*  12 */   private IntegerStack hStack = new IntegerStack(1024);
/*  13 */   private short historyFirst = -1;
/*     */   
/*     */   private final RoomPlacer p;
/*     */   private short tick;
/*     */   private int currentTick;
/*     */   
/*     */   UtilHistory(RoomPlacer p) {
/*  20 */     for (int i = 0; i < 1024; i++) {
/*  21 */       this.histories[i] = new HistoryI(i);
/*  22 */       this.hStack.push(i);
/*     */     } 
/*  24 */     this.p = p;
/*     */   }
/*     */   
/*     */   public void clear() {
/*  28 */     while (this.historyFirst != -1) {
/*  29 */       this.hStack.push(this.historyFirst);
/*  30 */       this.historyFirst = (this.histories[this.historyFirst]).next;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  35 */     this.historyFirst = -1;
/*     */   }
/*     */   
/*     */   private void init() {
/*  39 */     if (this.currentTick != GAME.updateI()) {
/*  40 */       this.tick = (short)(this.tick + 1);
/*  41 */       this.currentTick = GAME.updateI();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void placeDoor(int x1, int y1, int delta) {
/*  46 */     init();
/*  47 */     if (this.hStack.isEmpty()) {
/*  48 */       clearHistory(-1, this.historyFirst, 10);
/*     */     }
/*  50 */     int hi = this.hStack.pop();
/*  51 */     HistoryI h = this.histories[hi];
/*  52 */     h.x = (short)x1;
/*  53 */     h.y = (short)y1;
/*  54 */     h.action = ((short)delta == 1) ? HistoryI.actionDoor : HistoryI.actionDoorRemove;
/*  55 */     h.next = this.historyFirst;
/*  56 */     h.tick = this.tick;
/*  57 */     this.historyFirst = (short)hi;
/*     */   }
/*     */ 
/*     */   
/*     */   public void placeItem(FurnisherItem it, int x1, int y1, int delta) {
/*  62 */     init();
/*  63 */     if (this.hStack.isEmpty()) {
/*  64 */       clearHistory(-1, this.historyFirst, 10);
/*     */     }
/*  66 */     int hi = this.hStack.pop();
/*  67 */     HistoryI h = this.histories[hi];
/*     */ 
/*     */     
/*  70 */     if (delta < 0) {
/*  71 */       h.action = (short)(it.index() * delta);
/*     */     } else {
/*  73 */       h.action = (short)(1 + it.index());
/*  74 */       x1 += it.firstX();
/*  75 */       y1 += it.firstY();
/*     */     } 
/*  77 */     h.x = (short)x1;
/*  78 */     h.y = (short)y1;
/*  79 */     h.next = this.historyFirst;
/*  80 */     h.tick = this.tick;
/*  81 */     this.historyFirst = (short)hi;
/*     */   }
/*     */   
/*     */   public void placeEmbryo(int x1, int y1, int delta) {
/*  85 */     init();
/*  86 */     if (this.hStack.isEmpty()) {
/*  87 */       clearHistory(-1, this.historyFirst, 64);
/*     */     }
/*  89 */     int hi = this.hStack.pop();
/*  90 */     HistoryI h = this.histories[hi];
/*  91 */     h.x = (short)x1;
/*  92 */     h.y = (short)y1;
/*  93 */     h.action = (delta == -1) ? HistoryI.actionShrink : HistoryI.actionExpand;
/*  94 */     h.next = this.historyFirst;
/*  95 */     h.tick = this.tick;
/*  96 */     this.historyFirst = (short)hi;
/*     */   }
/*     */ 
/*     */   
/*     */   private int clearHistory(int previous, int current, int amount) {
/* 101 */     if (current == -1)
/* 102 */       return amount; 
/* 103 */     if (clearHistory(current, (this.histories[current]).next, amount) > 0) {
/* 104 */       this.hStack.push(current);
/* 105 */       (this.histories[current]).next = -1;
/* 106 */       if (previous == -1) {
/* 107 */         this.historyFirst = -1;
/*     */       } else {
/* 109 */         (this.histories[previous]).next = -1;
/*     */       } 
/*     */       
/* 112 */       return amount - 1;
/*     */     } 
/* 114 */     return 0;
/*     */   }
/*     */   
/*     */   public boolean hasHistory() {
/* 118 */     return (this.historyFirst != -1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void popHistory() {
/* 123 */     short hi = this.historyFirst;
/* 124 */     int t = (this.histories[hi]).tick;
/* 125 */     while (hi != -1 && (this.histories[hi]).tick == t) {
/* 126 */       HistoryI h = this.histories[hi];
/* 127 */       this.hStack.push(hi);
/* 128 */       hi = h.next;
/* 129 */       this.historyFirst = hi;
/* 130 */       if (h.action < 256) {
/* 131 */         if (h.action <= 0) {
/* 132 */           FurnisherItem it = this.p.blueprint().constructor().item(-h.action);
/* 133 */           if (this.p.placability.itemProblem(h.x, h.y, it.group, it, (AREA)this.p.instance) != null) {
/* 134 */             clear();
/*     */             
/*     */             return;
/*     */           } 
/* 138 */           for (int ry = 0; ry < it.height(); ry++) {
/* 139 */             for (int rx = 0; rx < it.width(); rx++) {
/* 140 */               if (this.p.placability.itemPlacable(h.x + rx, h.y + ry, rx, ry, it, (AREA)this.p.instance) != null || !this.p.instance.is(h.x + rx, h.y + ry)) {
/* 141 */                 clear();
/*     */                 return;
/*     */               } 
/*     */             } 
/*     */           } 
/* 146 */           (SETT.ROOMS()).fData.itemSet(h.x, h.y, it, this.p.instance); continue;
/*     */         } 
/* 148 */         (SETT.ROOMS()).fData.itemClear(h.x, h.y, (Room)this.p.instance); continue;
/*     */       } 
/* 150 */       if (h.action == HistoryI.actionExpand) {
/* 151 */         this.p.instance.clear(h.x, h.y); continue;
/* 152 */       }  if (h.action == HistoryI.actionShrink) {
/* 153 */         this.p.instance.set(h.x, h.y); continue;
/* 154 */       }  if (h.action == HistoryI.actionDoor) {
/* 155 */         this.p.door.removeWithoutHistory(h.x, h.y); continue;
/* 156 */       }  if (h.action == HistoryI.actionDoorRemove) {
/* 157 */         this.p.door.placeWithoutHistory(h.x, h.y);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static class HistoryI
/*     */   {
/* 167 */     private static short actionExpand = 257;
/* 168 */     private static short actionShrink = 258;
/* 169 */     private static short actionDoor = (short)(actionShrink + 1);
/* 170 */     private static short actionDoorRemove = (short)(actionDoor + 32);
/*     */     private short next;
/*     */     private short x;
/*     */     private short y;
/*     */     private short action;
/*     */     private short tick;
/*     */     
/*     */     HistoryI(int index) {}
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\placement\UtilHistory.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */