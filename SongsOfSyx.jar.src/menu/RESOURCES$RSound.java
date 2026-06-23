/*     */ package menu;
/*     */ 
/*     */ import game.audio.AudioFactory;
/*     */ import init.constant.C;
/*     */ import init.paths.PATH;
/*     */ import init.paths.PATHS;
/*     */ import java.nio.file.Path;
/*     */ import snake2d.CORE;
/*     */ import snake2d.SoundEffect;
/*     */ import snake2d.SoundSimple;
/*     */ import snake2d.SoundStream;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class RSound
/*     */ {
/*     */   public boolean playing;
/*     */   public final SoundStream music;
/*     */   public final SoundStream s;
/*     */   public final SoundStream logo;
/*     */   
/*     */   RSound() {
/*  74 */     Json json = new Json((PATHS.AUDIO()).config.gets("Menu"));
/*     */     
/*  76 */     AudioFactory<SoundStream> fm = new AudioFactory<SoundStream>("MUSIC", (PATHS.AUDIO()).music, (SoundStream)new SoundStream.Dummy())
/*     */       {
/*     */         protected SoundStream create(LinkedList<SoundStream> all, Path p, String key)
/*     */         {
/*  80 */           return CORE.getSoundCore().getStream(p, true);
/*     */         }
/*     */       };
/*     */     
/*  84 */     this.music = (SoundStream)fm.read("MENU", json).get(0);
/*  85 */     this.logo = (SoundStream)fm.read("LOGO", json).get(0);
/*  86 */     this.s = (SoundStream)fm.read("TORCH", json).get(0);
/*     */     
/*  88 */     AudioFactory<SoundEffect> sm = new AudioFactory<SoundEffect>("SOUND", (PATHS.AUDIO()).mono, (SoundEffect)new SoundEffect.Dummy())
/*     */       {
/*     */         protected SoundEffect create(LinkedList<SoundEffect> all, Path p, String key)
/*     */         {
/*  92 */           return CORE.getSoundCore().getEffect(p);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  97 */     CLICKABLE.ClickableAbs.defaultClickSound = (SoundSimple)sm.read("CLICK", json).get(0);
/*  98 */     CLICKABLE.ClickableAbs.defaultHoverSound = (SoundSimple)sm.read("HOVER", json).get(0);
/*     */     
/* 100 */     CORE.getSoundCore().set(C.WIDTH() / 2, C.HEIGHT() / 2);
/*     */   }
/*     */ 
/*     */   
/*     */   void play() {
/* 105 */     if (this.playing)
/*     */       return; 
/* 107 */     this.logo.stop();
/*     */     
/* 109 */     this.music.play();
/* 110 */     this.s.setLooping(true);
/* 111 */     this.s.play();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\menu\RESOURCES$RSound.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */