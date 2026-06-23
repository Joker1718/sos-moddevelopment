/*     */ package game.audio;
/*     */ 
/*     */ import init.constant.C;
/*     */ import java.util.Arrays;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.SoundStream;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import util.data.DOUBLE;
/*     */ import util.data.INT;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GHeader;
/*     */ import util.gui.slider.GSliderInt;
/*     */ import util.gui.table.GScrollRows;
/*     */ import view.interrupter.IDebugPanel;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ 
/*     */ final class Debug
/*     */ {
/*     */   Debug() {
/*  24 */     IDebugPanel.add("AUDION: MUSIC SHUFFLE", new ACTION()
/*     */         {
/*     */           public void exe() {
/*  27 */             AUDIO.music().next();
/*     */           }
/*     */         });
/*     */     
/*  31 */     IDebugPanel.add("AUDIO: AMBIENCE", new ACTION()
/*     */         {
/*     */           public void exe()
/*     */           {
/*  35 */             (VIEW.inters()).popup.show((RENDEROBJ)Debug.this.ambience(), null);
/*     */           }
/*     */         });
/*     */     
/*  39 */     IDebugPanel.add("AUDIO: STREAMS", new ACTION()
/*     */         {
/*     */           public void exe()
/*     */           {
/*  43 */             (VIEW.inters()).popup.show((RENDEROBJ)Debug.this.streams(), null);
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private GuiSection ambience() {
/*  54 */     LinkedList<RENDEROBJ> rows = new LinkedList();
/*     */     
/*  56 */     final double[] priority = new double[AUDIO.AMBI().all().size()];
/*  57 */     final double[] gains = new double[AUDIO.AMBI().all().size()];
/*  58 */     Arrays.fill(gains, 1.0D);
/*     */     
/*  60 */     for (Ambiance a : AUDIO.AMBI().all()) {
/*     */       
/*  62 */       GuiSection row = new GuiSection();
/*     */       
/*  64 */       row.add((RENDEROBJ)new GHeader(a.key()));
/*     */       
/*  66 */       INT.INTE prio = new INT.INTE()
/*     */         {
/*     */           
/*     */           public int min()
/*     */           {
/*  71 */             return 0;
/*     */           }
/*     */ 
/*     */           
/*     */           public int max() {
/*  76 */             return 200;
/*     */           }
/*     */ 
/*     */           
/*     */           public int get() {
/*  81 */             return (int)(priority[a.index()] * 100.0D);
/*     */           }
/*     */ 
/*     */           
/*     */           public void set(int t) {
/*  86 */             priority[a.index()] = t / 100.0D;
/*     */           }
/*     */         };
/*     */       
/*  90 */       row.addRightCAbs(300, (RENDEROBJ)new GSliderInt(prio, 100, true));
/*     */       
/*  92 */       INT.INTE gain = new INT.INTE()
/*     */         {
/*     */           
/*     */           public int min()
/*     */           {
/*  97 */             return 0;
/*     */           }
/*     */ 
/*     */           
/*     */           public int max() {
/* 102 */             return 200;
/*     */           }
/*     */ 
/*     */           
/*     */           public int get() {
/* 107 */             return (int)(gains[a.index()] * 100.0D);
/*     */           }
/*     */ 
/*     */           
/*     */           public void set(int t) {
/* 112 */             gains[a.index()] = t / 100.0D;
/*     */           }
/*     */         };
/*     */       
/* 116 */       row.addRightC(16, (RENDEROBJ)new GSliderInt(gain, 100, true));
/*     */       
/* 118 */       rows.add(row);
/*     */     } 
/*     */     
/* 121 */     GuiSection s = new GuiSection()
/*     */       {
/*     */         public void render(SPRITE_RENDERER r, float ds)
/*     */         {
/* 125 */           (AUDIO.AMBI_UP()).debugPrio = priority;
/* 126 */           (AUDIO.AMBI_UP()).debugGain = gains;
/* 127 */           super.render(r, ds);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 132 */     s.add((RENDEROBJ)(new GScrollRows((Iterable)rows, C.HEIGHT() - 200)).view());
/*     */     
/* 134 */     return s;
/*     */   }
/*     */ 
/*     */   
/*     */   private GuiSection streams() {
/* 139 */     LinkedList<RENDEROBJ> rows = new LinkedList();
/*     */     
/* 141 */     final double[] priority = new double[AUDIO.AMBI().all().size()];
/* 142 */     final double[] gains = new double[AUDIO.AMBI().all().size()];
/* 143 */     Arrays.fill(gains, 1.0D);
/*     */     
/* 145 */     for (String str : (AUDIO.AMBI()).factory.map().keysSorted()) {
/* 146 */       final SoundStream st = (SoundStream)(AUDIO.AMBI()).factory.map().get(str);
/*     */       
/* 148 */       rows.add(new GButt.ButtPanel(str)
/*     */           {
/*     */             protected void clickA() {
/* 151 */               st.playOnce();
/* 152 */               super.clickA();
/*     */             }
/*     */           });
/*     */     } 
/*     */ 
/*     */     
/* 158 */     GuiSection s = new GuiSection()
/*     */       {
/*     */         public void render(SPRITE_RENDERER r, float ds)
/*     */         {
/* 162 */           (AUDIO.AMBI_UP()).debugPrio = priority;
/* 163 */           (AUDIO.AMBI_UP()).debugGain = gains;
/* 164 */           super.render(r, ds);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 169 */     s.add((RENDEROBJ)(new GScrollRows((Iterable)rows, C.HEIGHT() - 200)).view());
/*     */     
/* 171 */     return s;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\audio\Debug.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */