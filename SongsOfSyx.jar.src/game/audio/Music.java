/*     */ package game.audio;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.time.TIME;
/*     */ import init.paths.PATHS;
/*     */ import java.util.Random;
/*     */ import snake2d.SoundStream;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.LIST;
/*     */ 
/*     */ public final class Music
/*     */ {
/*     */   private final MusicFactory factory;
/*     */   private SoundStream current;
/*     */   
/*     */   public AudioFactory<SoundStream> factory() {
/*  19 */     return this.factory;
/*     */   }
/*     */ 
/*     */   
/*     */   private SoundStream[] currentA;
/*     */   
/*     */   private final SoundStream[] normal;
/*     */   private final SoundStream[] battle;
/*  27 */   private int r = 0;
/*     */   
/*  29 */   private double fade = 0.0D;
/*  30 */   private double timeout = 0.0D;
/*     */   
/*     */   private boolean shuffle = false;
/*     */   
/*     */   Music() {
/*  35 */     this.factory = new MusicFactory();
/*     */     
/*  37 */     Json json = new Json((PATHS.AUDIO()).config.gets("Music"));
/*     */     
/*  39 */     this.normal = get(this.factory.read("NORMAL", json));
/*  40 */     this.battle = get(this.factory.read("BATTLE", json));
/*     */     
/*  42 */     this.currentA = this.normal;
/*  43 */     this.current = this.currentA[0];
/*  44 */     this.current.setGain(1.0D);
/*  45 */     this.fade = 1.0D;
/*  46 */     this.current.play();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void update(double ds) {
/*  54 */     if (GAME.ARMIES().enemy().men() > 0) {
/*  55 */       if (this.shuffle || this.currentA != this.battle) {
/*  56 */         if (this.fade < 0.0D) {
/*  57 */           this.current.stop();
/*  58 */           this.currentA = this.battle;
/*  59 */           this.shuffle = false;
/*  60 */           this.fade = 1.0D;
/*     */         } else {
/*  62 */           this.current.setGain(this.fade);
/*     */         } 
/*  64 */         this.fade -= ds;
/*  65 */       } else if (!this.current.isPlaying()) {
/*  66 */         this.fade = CLAMP.d(this.fade + ds, 0.0D, 1.0D);
/*  67 */         this.r++;
/*  68 */         this.r %= this.currentA.length;
/*  69 */         this.current = this.currentA[this.r];
/*  70 */         this.current.setGain(this.fade);
/*  71 */         this.current.play();
/*     */       } 
/*  73 */     } else if (TIME.light().dayIs()) {
/*  74 */       if (this.shuffle || this.currentA != this.normal) {
/*  75 */         if (this.fade < 0.0D) {
/*  76 */           this.current.stop();
/*  77 */           this.currentA = this.normal;
/*  78 */           this.shuffle = false;
/*  79 */           this.fade = 1.0D;
/*  80 */           this.timeout = (2 + RND.rInt(10));
/*     */         } else {
/*  82 */           this.current.setGain(this.fade);
/*     */         } 
/*  84 */         this.fade -= ds;
/*  85 */       } else if (!this.current.isPlaying()) {
/*  86 */         if (this.timeout > 0.0D) {
/*  87 */           this.timeout -= ds;
/*     */         } else {
/*  89 */           this.fade = CLAMP.d(this.fade + ds, 0.0D, 1.0D);
/*  90 */           this.r++;
/*  91 */           this.r %= this.currentA.length;
/*  92 */           this.current = this.currentA[this.r];
/*  93 */           this.current.setGain(this.fade);
/*  94 */           this.current.play();
/*     */         }
/*     */       
/*     */       }
/*     */     
/*     */     }
/* 100 */     else if (this.currentA == this.battle) {
/* 101 */       if (this.fade < 0.0D) {
/* 102 */         this.current.stop();
/*     */       }
/* 104 */       this.fade -= ds;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private SoundStream[] get(LIST<SoundStream> streams) {
/* 114 */     SoundStream[] res = new SoundStream[streams.size()];
/* 115 */     int i = 0;
/* 116 */     for (SoundStream s : streams) {
/* 117 */       res[i++] = s;
/*     */     }
/* 119 */     Random ran = new Random();
/* 120 */     ran.setSeed(System.currentTimeMillis());
/* 121 */     for (int k = 0; k < res.length * 4; k++) {
/* 122 */       int i1 = ran.nextInt(res.length);
/* 123 */       int i2 = ran.nextInt(res.length);
/* 124 */       SoundStream s = res[i1];
/* 125 */       res[i1] = res[i2];
/* 126 */       res[i2] = s;
/*     */     } 
/*     */     
/* 129 */     return res;
/*     */   }
/*     */ 
/*     */   
/*     */   public void next() {
/* 134 */     this.shuffle = true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\audio\Music.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */