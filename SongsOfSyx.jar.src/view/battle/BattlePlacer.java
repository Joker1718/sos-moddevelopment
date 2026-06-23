/*     */ package view.battle;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.div.Div;
/*     */ import game.battle.thread.order.BattleOrderTask;
/*     */ import game.battle.util.Copyable;
/*     */ import settlement.room.military.artillery.ArtilleryInstance;
/*     */ import snake2d.MButt;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Alloc;
/*     */ import util.gui.misc.GBox;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import view.keyboard.KEYS;
/*     */ import view.keyboard.Key;
/*     */ import view.subview.GameWindow;
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class BattlePlacer
/*     */ {
/*     */   private final GameWindow w;
/*     */   final DivSelection s;
/*     */   private final BattlePlacerRenderer ren;
/*     */   Mode current;
/*     */   private final Mode selectMore;
/*     */   private final Mode position;
/*     */   private final Mode spin;
/*     */   private final BattlePlacerAttack attack;
/*  33 */   private final Action action = new Action();
/*  34 */   private final BattleOrderTask task = new BattleOrderTask();
/*     */ 
/*     */ 
/*     */   
/*     */   private final Key[] arrowsKeys;
/*     */ 
/*     */   
/*     */   private final DIR[] arrowsDIRS;
/*     */ 
/*     */   
/*     */   private final int[] arrowPressed;
/*     */ 
/*     */ 
/*     */   
/*     */   public void click(MButt butt) {
/*  49 */     if (butt == MButt.LEFT) {
/*  50 */       this.action.clicked = true;
/*  51 */       this.action.start.set((COORDINATE)this.w.pixel());
/*  52 */     } else if (butt == MButt.RIGHT) {
/*  53 */       if (this.action.clicked) {
/*  54 */         this.action.clicked = false;
/*     */       } else {
/*  56 */         this.s.clear();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*  61 */   public BattlePlacer(GameWindow w, DivSelection s) { this
/*     */ 
/*     */ 
/*     */       
/*  65 */       .arrowsKeys = new Key[] { (KEYS.BATTLE()).UP, (KEYS.BATTLE()).DOWN, (KEYS.BATTLE()).LEFT, (KEYS.BATTLE()).RIGHT };
/*     */ 
/*     */     
/*  68 */     this
/*  69 */       .arrowsDIRS = new DIR[] { DIR.N, DIR.S, DIR.W, DIR.E };
/*     */ 
/*     */     
/*  72 */     this.arrowPressed = Alloc.ii(4); this.w = w; this.s = s; this.selectMore = new BattlePlacerSelect(w, s, this.action);
/*     */     this.position = new BattlePlacerPlace(w, s, this.action);
/*     */     this.spin = new BattlePlacerSpin(w, s, this.action);
/*     */     this.attack = new BattlePlacerAttack(w, s, this.action);
/*     */     this.current = this.selectMore;
/*  77 */     this.ren = new BattlePlacerRenderer(this); } void keypush() { int dx = 0;
/*  78 */     int dy = 0;
/*     */     
/*  80 */     if ((KEYS.BATTLE()).SELECT_ALL.consumeClick()) {
/*  81 */       this.action.clicked = false;
/*  82 */       this.s.clear();
/*  83 */       boolean allSelected = true;
/*  84 */       for (Div d : GAME.ARMIES().player().divisions()) {
/*  85 */         if (d.menNrOf() > 0) {
/*  86 */           allSelected &= this.s.selected(d);
/*  87 */           this.s.select(d);
/*     */         } 
/*     */       } 
/*  90 */       if (allSelected) {
/*  91 */         for (ArtilleryInstance ins : this.s.artillery.all()) {
/*  92 */           this.s.artillery.select(ins);
/*     */         }
/*     */       }
/*     */     } 
/*     */     
/*  97 */     if ((KEYS.MAIN()).BACKSPACE.consumeClick()) {
/*  98 */       this.action.clicked = false;
/*  99 */       for (Div d : this.s.selection()) {
/* 100 */         this.task.stop(d);
/* 101 */         (d.order()).task.set((Copyable)this.task);
/*     */       } 
/* 103 */       for (ArtilleryInstance ins : this.s.artillery.all()) {
/* 104 */         ins.clearTarget();
/*     */       }
/*     */     } 
/*     */     
/* 108 */     for (int i = 0; i < this.arrowsKeys.length; i++) {
/* 109 */       if (this.arrowsKeys[i].consumeClick()) {
/* 110 */         dx += this.arrowsDIRS[i].x() * 64;
/* 111 */         dy += this.arrowsDIRS[i].y() * 64;
/* 112 */       } else if (this.arrowsKeys[i].isPressed()) {
/* 113 */         this.arrowPressed[i] = this.arrowPressed[i] + 1; if (this.arrowPressed[i] > 60) {
/* 114 */           dx += this.arrowsDIRS[i].x() * (this.arrowPressed[i] - 60) * 8;
/* 115 */           dy += this.arrowsDIRS[i].y() * (this.arrowPressed[i] - 60) * 8;
/* 116 */           this.arrowPressed[i] = 60;
/*     */         } 
/*     */       } else {
/* 119 */         this.arrowPressed[i] = 0;
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 125 */     if ((KEYS.BATTLE()).UP.consumeClick())
/* 126 */       dy = -64; 
/* 127 */     if ((KEYS.BATTLE()).DOWN.consumeClick()) {
/* 128 */       dy = 64;
/*     */     }
/*     */     
/* 131 */     if ((KEYS.BATTLE()).LEFT.consumeClick())
/* 132 */       dx = -64; 
/* 133 */     if ((KEYS.BATTLE()).RIGHT.consumeClick()) {
/* 134 */       dx = 64;
/*     */     }
/*     */     
/* 137 */     if (dx == 0 && dy == 0)
/*     */       return; 
/* 139 */     this.action.clicked = false;
/* 140 */     for (Div d : this.s.selection()) {
/* 141 */       (GAME.ARMIES()).placer.deploy(d, dx, dy);
/*     */     } }
/*     */ 
/*     */ 
/*     */   
/*     */   private Mode getState() {
/* 147 */     if (this.s.allSelected() <= 0)
/* 148 */       return this.selectMore; 
/* 149 */     if (this.attack.init()) {
/* 150 */       return this.attack;
/*     */     }
/* 152 */     if (this.s.allSelected() <= 0 || (KEYS.MAIN()).UNDO.isPressed())
/* 153 */       return this.selectMore; 
/* 154 */     if ((KEYS.MAIN()).MOD.isPressed()) {
/* 155 */       return this.spin;
/*     */     }
/* 157 */     return this.position;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void update(boolean hovered) {
/* 163 */     this.current = getState();
/*     */     
/* 165 */     keypush();
/* 166 */     this.action.clickReleased = false;
/*     */     
/* 168 */     if (this.action.clicked && !MButt.LEFT.isDown()) {
/* 169 */       this.action.clicked = false;
/* 170 */       this.action.clickReleased = true;
/*     */     } 
/*     */ 
/*     */     
/* 174 */     this.ren.add(hovered);
/* 175 */     this.current.update(hovered);
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverTimer(GBox text) {
/* 180 */     this.current.hoverTimer(text);
/*     */   }
/*     */   
/*     */   static abstract class Mode
/*     */   {
/*     */     abstract void update(boolean param1Boolean);
/*     */     
/*     */     abstract void hoverTimer(GBox param1GBox);
/*     */     
/*     */     abstract void render(Renderer param1Renderer, ShadowBatch param1ShadowBatch, RenderData param1RenderData, double param1Double);
/*     */   }
/*     */   
/*     */   static final class Action
/*     */   {
/* 194 */     public Coo start = new Coo();
/*     */     public boolean clicked;
/*     */     public boolean clickReleased;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\battle\BattlePlacer.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */