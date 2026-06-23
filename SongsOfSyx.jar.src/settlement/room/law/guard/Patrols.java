/*     */ package settlement.room.law.guard;
/*     */ 
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UI;
/*     */ import java.io.IOException;
/*     */ import settlement.overlay.Addable;
/*     */ import snake2d.CORE;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sets.IntegerStack;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GButt;
/*     */ import util.rendering.RenderData;
/*     */ import view.main.VIEW;
/*     */ import view.sett.IDebugPanelSett;
/*     */ 
/*     */ public class Patrols
/*     */   implements SAVABLE {
/*  26 */   private final Patrol[] patrols = new Patrol[16];
/*     */   
/*     */   private boolean debug = false;
/*  29 */   private final IntegerStack free = new IntegerStack(this.patrols.length * Patrol.MAX);
/*     */ 
/*     */   
/*  32 */   private final Addable a = new Addable(false, true)
/*     */     {
/*     */       
/*     */       public void initAbove(RenderData data)
/*     */       {
/*  37 */         COLOR.RED100.bind();
/*  38 */         for (int pi = 0; pi < Patrols.this.patrols.length; pi++) {
/*  39 */           Patrol p = Patrols.this.patrols[pi];
/*  40 */           ((COLOR)COLOR.UNIQUE.getC(pi)).bind();
/*  41 */           for (int i = 0; i < p.posses(); i++) {
/*  42 */             Coo coo = p.pos(i);
/*  43 */             int px = data.transformGX(coo.x() - 32);
/*  44 */             int py = data.transformGY(coo.y() - 32);
/*  45 */             (SPRITES.cons()).BIG.outline.render((SPRITE_RENDERER)CORE.renderer(), 0, px, py);
/*     */           } 
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  52 */         COLOR.unbind();
/*  53 */         super.initAbove(data);
/*  54 */         add();
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*     */   Patrols() {
/*  60 */     for (int i = 0; i < this.patrols.length; i++) {
/*  61 */       this.patrols[i] = new Patrol();
/*     */     }
/*  63 */     this.free.fill();
/*     */ 
/*     */     
/*  66 */     IDebugPanelSett.add("show patrols", new ACTION()
/*     */         {
/*     */ 
/*     */           
/*     */           public void exe()
/*     */           {
/*  72 */             Coo coo = Patrols.this.patrols[0].pos(0);
/*  73 */             (VIEW.s().getWindow()).centerer.set(coo.x(), coo.y());
/*  74 */             Patrols.this.debug = true;
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public CLICKABLE debugButt() {
/*  80 */     return (CLICKABLE)new GButt.ButtPanel((SPRITE)(UI.icons()).m.crossair)
/*     */       {
/*  82 */         int pi = 0;
/*     */ 
/*     */ 
/*     */         
/*     */         protected void clickA() {
/*  87 */           if (this.pi >= Patrols.this.patrols.length)
/*  88 */             this.pi = 0; 
/*  89 */           Patrol p = Patrols.this.patrols[this.pi];
/*  90 */           Coo coo = p.pos(0);
/*  91 */           (VIEW.s().getWindow()).centerer.set(coo.x(), coo.y());
/*  92 */           Patrols.this.debug = true;
/*     */         }
/*     */       };
/*     */   }
/*     */   void update(double ds) {
/*     */     byte b;
/*     */     int i;
/*     */     Patrol[] arrayOfPatrol;
/* 100 */     for (i = (arrayOfPatrol = this.patrols).length, b = 0; b < i; ) { Patrol p = arrayOfPatrol[b];
/* 101 */       p.update(ds); b++; }
/* 102 */      if (this.debug)
/* 103 */       this.a.add(); 
/*     */   }
/*     */   
/*     */   public int reservePosition() {
/* 107 */     if (!this.free.isEmpty()) {
/* 108 */       int p = this.free.pop();
/* 109 */       return p;
/*     */     } 
/* 111 */     return -1;
/*     */   }
/*     */   
/*     */   public void returnPosition(int pos) {
/* 115 */     this.free.push(pos);
/*     */   }
/*     */   
/*     */   public Coo pos(int position) {
/* 119 */     int p = position / Patrol.MAX;
/* 120 */     int pp = position % Patrol.MAX;
/*     */     
/* 122 */     return this.patrols[p].pos(pp);
/*     */   }
/*     */   
/*     */   public DIR dir(int position) {
/* 126 */     int p = position / Patrol.MAX;
/* 127 */     int pp = position % Patrol.MAX;
/* 128 */     return this.patrols[p].dir(pp);
/*     */   }
/*     */ 
/*     */   
/*     */   public void save(FilePutter file) {
/* 133 */     this.free.save(file); byte b; int i; Patrol[] arrayOfPatrol;
/* 134 */     for (i = (arrayOfPatrol = this.patrols).length, b = 0; b < i; ) { Patrol p = arrayOfPatrol[b];
/* 135 */       p.save(file);
/*     */       b++; }
/*     */   
/*     */   }
/*     */   public void load(FileGetter file) throws IOException {
/* 140 */     this.free.load(file); byte b; int i; Patrol[] arrayOfPatrol;
/* 141 */     for (i = (arrayOfPatrol = this.patrols).length, b = 0; b < i; ) { Patrol p = arrayOfPatrol[b];
/* 142 */       p.load(file);
/*     */       b++; }
/*     */   
/*     */   }
/*     */   public void clear() {
/* 147 */     this.free.clear();
/* 148 */     this.free.fill(); byte b; int i; Patrol[] arrayOfPatrol;
/* 149 */     for (i = (arrayOfPatrol = this.patrols).length, b = 0; b < i; ) { Patrol p = arrayOfPatrol[b];
/* 150 */       p.clear();
/*     */       b++; }
/*     */   
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\law\guard\Patrols.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */