/*     */ package game.audio;
/*     */ 
/*     */ import snake2d.SoundStream;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.Tree;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class AmbianceUpdater
/*     */ {
/*  13 */   private final Channel[] channels = new Channel[] { new Channel(), new Channel(), new Channel(), new Channel(), new Channel() };
/*     */   
/*     */   private Tree<Ambiance> aSort;
/*  16 */   private final ArrayList<Channel> cfree = new ArrayList(this.channels.length);
/*  17 */   private final ArrayList<Ambiance> toPlay = new ArrayList(this.channels.length);
/*     */   private final Ambiances aaa;
/*     */   private double last;
/*     */   double[] debugPrio;
/*     */   double[] debugGain;
/*     */   
/*     */   AmbianceUpdater(Ambiances aaa) {
/*  24 */     this.last = -100.0D;
/*     */     this.aaa = aaa;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void update() {
/*  31 */     double ds = (float)(VIEW.renderSecond() - this.last);
/*  32 */     if (ds < 0.1D)
/*     */       return; 
/*  34 */     this.last = VIEW.renderSecond();
/*     */     
/*  36 */     if (this.debugPrio != null) {
/*  37 */       for (Ambiance a : this.aaa.all()) {
/*  38 */         a.priority = this.debugPrio[a.index()];
/*  39 */         if (a.priority > 0.0D) {
/*  40 */           a.gainSet(this.debugGain[a.index()]);
/*     */         }
/*     */       } 
/*     */       
/*  44 */       this.debugPrio = null;
/*  45 */       this.debugGain = null;
/*     */     } 
/*  47 */     if (this.aSort == null || this.aSort.capacity() != this.aaa.all().size()) {
/*  48 */       this.aSort = new Tree<Ambiance>(this.aaa.all().size())
/*     */         {
/*     */           protected boolean isGreaterThan(Ambiance current, Ambiance cmp)
/*     */           {
/*  52 */             return (current.priority > cmp.priority);
/*     */           }
/*     */         };
/*     */     }
/*     */ 
/*     */     
/*  58 */     this.aSort.clear();
/*  59 */     for (Ambiance a : this.aaa.all()) {
/*  60 */       if (a.priority > 0.0D) {
/*  61 */         this.aSort.add(a);
/*     */       }
/*     */     } 
/*     */     
/*  65 */     this.toPlay.clearSloppy();
/*     */     
/*  67 */     int ci = 0;
/*  68 */     while (this.aSort.hasMore()) {
/*  69 */       Ambiance a = (Ambiance)this.aSort.pollGreatest();
/*  70 */       if (ci < this.channels.length) {
/*  71 */         if (a.channel == null)
/*  72 */           this.toPlay.add(a); 
/*     */       } else {
/*  74 */         a.priority = 0.0D;
/*     */       } 
/*  76 */       ci++;
/*     */     } 
/*     */     
/*  79 */     this.cfree.clearSloppy(); byte b; int j; Channel[] arrayOfChannel;
/*  80 */     for (j = (arrayOfChannel = this.channels).length, b = 0; b < j; ) { Channel c = arrayOfChannel[b];
/*  81 */       c.update(ds);
/*  82 */       if (c.current == null) {
/*  83 */         this.cfree.add(c);
/*     */       }
/*     */       b++; }
/*     */     
/*  87 */     for (int i = 0; i < this.toPlay.size() && i < this.cfree.size(); i++) {
/*  88 */       ((Channel)this.cfree.get(i)).init((Ambiance)this.toPlay.get(i));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   static final class Channel
/*     */   {
/*     */     private Ambiance current;
/*     */     
/*     */     private SoundStream stream;
/*     */     
/*     */     private double gain;
/*     */     
/*     */     public void update(double ds) {
/* 102 */       if (this.current == null) {
/*     */         return;
/*     */       }
/* 105 */       if (!this.stream.isPlaying()) {
/* 106 */         if (this.current.priority > 0.0D) {
/* 107 */           init(this.current);
/*     */         } else {
/* 109 */           this.current.channel = null;
/* 110 */           this.current = null;
/*     */         } 
/*     */         
/*     */         return;
/*     */       } 
/* 115 */       if (this.current.priority <= 0.0D) {
/* 116 */         this.gain -= ds;
/* 117 */         if (this.gain <= 0.0D) {
/* 118 */           this.gain = 0.0D;
/* 119 */           this.stream.stop();
/*     */         } 
/*     */       } else {
/* 122 */         double g = this.current.gain();
/* 123 */         if (this.gain < g) {
/* 124 */           this.gain += ds;
/* 125 */           if (this.gain > g)
/* 126 */             this.gain = g; 
/* 127 */         } else if (this.gain > g) {
/* 128 */           this.gain -= ds;
/* 129 */           if (this.gain < g) {
/* 130 */             this.gain = g;
/*     */           }
/*     */         } 
/*     */       } 
/* 134 */       this.gain = CLAMP.d(this.gain, 0.0D, 1.0D);
/* 135 */       this.stream.setGain(this.gain);
/*     */     }
/*     */ 
/*     */     
/*     */     public void init(Ambiance c) {
/* 140 */       c.channel = this;
/* 141 */       this.current = c;
/* 142 */       this.stream = (SoundStream)c.streams.rnd();
/* 143 */       this.stream.setLooping(false);
/* 144 */       this.gain = 0.0D;
/* 145 */       this.stream.setGain(this.gain);
/* 146 */       this.stream.play();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\audio\AmbianceUpdater.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */