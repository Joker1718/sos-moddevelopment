/*     */ package view.keyboard;
/*     */ 
/*     */ import init.constant.C;
/*     */ import init.sprite.UI.UI;
/*     */ import java.util.ArrayList;
/*     */ import snake2d.KeyBoard;
/*     */ import snake2d.MButt;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.sets.LIST;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GText;
/*     */ import util.text.D;
/*     */ import view.interrupter.Interrupter;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ final class IChange
/*     */   extends Interrupter
/*     */   implements KeyPoller {
/*  24 */   private final GuiSection section = new GuiSection();
/*     */   private Key key;
/*     */   private int codeMod;
/*     */   private int codeKey;
/*     */   private int triedcodeMod;
/*     */   private int triedcodeKey;
/*  30 */   private final ArrayList<Key> errorKey = new ArrayList<>(64);
/*  31 */   private double timer = 0.0D;
/*     */   
/*  33 */   private static CharSequence ¤¤Pick = "¤Pick a hotkey for:";
/*  34 */   private static CharSequence ¤¤Explanation = "¤Either press a single key, or press and hold a key to use as a modulator, then press another key. Hit escape to exit.";
/*     */   
/*  36 */   private static CharSequence ¤¤Sucess = "¤Hotkey {0} successfully mapped to {1}!";
/*  37 */   private static CharSequence ¤¤Fail = "¤Hotkey {0} is already in use by {1}, pick another one.";
/*  38 */   private static CharSequence ¤¤Overwritten = "¤{0} is now without a hotkey!";
/*  39 */   private final GText text = new GText((UI.FONT()).M, 120);
/*     */   
/*     */   static {
/*  42 */     D.ts(IChange.class);
/*     */   }
/*     */   
/*     */   public IChange() {
/*  46 */     this.text.setMaxWidth(600);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean hover(COORDINATE mCoo, boolean mouseHasMoved) {
/*  51 */     this.section.hover(mCoo);
/*  52 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void mouseClick(MButt button) {
/*  57 */     this.section.click();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void hoverTimer(GBox text) {
/*  62 */     this.section.hoverInfoGet((GUI_BOX)text);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean render(Renderer r, float ds) {
/*  68 */     int cx = C.DIM().cX();
/*  69 */     int y1 = C.DIM().cY() - 200;
/*     */     
/*  71 */     this.text.setFont((UI.FONT()).H1);
/*  72 */     this.text.lablify();
/*  73 */     this.text.set(¤¤Pick);
/*  74 */     this.text.renderC((SPRITE_RENDERER)r, cx, y1);
/*  75 */     y1 += this.text.height();
/*     */     
/*  77 */     this.text.setFont((UI.FONT()).H2);
/*  78 */     this.text.lablifySub();
/*  79 */     this.text.set(this.key.name);
/*  80 */     this.text.renderC((SPRITE_RENDERER)r, cx, y1);
/*  81 */     y1 += this.text.height() + 8;
/*     */     
/*  83 */     this.text.setFont((UI.FONT()).M);
/*  84 */     this.text.normalify();
/*  85 */     this.text.set(this.key.desc);
/*  86 */     this.text.renderC((SPRITE_RENDERER)r, cx, y1);
/*  87 */     y1 += this.text.height() + 16;
/*     */     
/*  89 */     if (this.timer > 0.0D) {
/*  90 */       this.text.clear();
/*  91 */       this.text.setFont((UI.FONT()).H2);
/*  92 */       this.text.normalify2();
/*  93 */       this.text.add(¤¤Sucess);
/*  94 */       this.text.insert(0, this.key.name);
/*  95 */       this.text.insert(1, this.key.repr());
/*  96 */       this.text.adjustWidth();
/*  97 */       this.text.renderC((SPRITE_RENDERER)r, cx, y1);
/*  98 */       int y = y1 + 32;
/*  99 */       for (Key e : this.errorKey) {
/* 100 */         this.text.clear();
/* 101 */         this.text.setFont((UI.FONT()).M);
/* 102 */         this.text.errorify();
/* 103 */         this.text.add(¤¤Overwritten);
/* 104 */         this.text.insert(0, e.name);
/* 105 */         this.text.adjustWidth();
/* 106 */         this.text.renderC((SPRITE_RENDERER)r, cx, y);
/* 107 */         y += 32;
/*     */       } 
/* 109 */     } else if (this.codeMod == -1 && this.triedcodeKey != -1) {
/* 110 */       if (this.errorKey.size() > 0) {
/* 111 */         int y = y1 + 32;
/* 112 */         for (Key e : this.errorKey) {
/* 113 */           this.text.setFont((UI.FONT()).M);
/* 114 */           this.text.errorify();
/* 115 */           this.text.clear().add(¤¤Fail);
/* 116 */           this.text.insert(0, e.repr());
/* 117 */           this.text.insert(1, e.name);
/* 118 */           this.text.adjustWidth();
/* 119 */           this.text.renderC((SPRITE_RENDERER)r, cx, y);
/* 120 */           y += 32;
/*     */         }
/*     */       
/*     */       }
/*     */     
/*     */     }
/* 126 */     else if (this.codeMod != -1) {
/* 127 */       this.text.setFont((UI.FONT()).H2);
/* 128 */       this.text.normalify();
/* 129 */       this.text.set(KEYS.names.getCode(this.codeMod));
/* 130 */       this.text.renderC((SPRITE_RENDERER)r, cx, y1);
/*     */     } else {
/* 132 */       this.text.setFont((UI.FONT()).M);
/* 133 */       this.text.color(COLOR.WHITE702WHITE100);
/* 134 */       this.text.normalify();
/* 135 */       this.text.set(¤¤Explanation);
/* 136 */       this.text.renderC((SPRITE_RENDERER)r, cx, y1 + 32);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 143 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean update(float ds) {
/* 151 */     if (this.timer > 0.0D) {
/* 152 */       this.timer -= ds;
/* 153 */       if (this.timer <= 0.0D || MButt.LEFT.consumeClick()) {
/* 154 */         hide();
/*     */       }
/* 156 */       VIEW.setKeyPoller(this);
/* 157 */       return true;
/*     */     } 
/* 159 */     VIEW.setKeyPoller(this);
/*     */     
/* 161 */     if (this.codeKey != -1) {
/*     */       
/* 163 */       this.triedcodeKey = this.codeKey;
/* 164 */       this.triedcodeMod = this.codeMod;
/* 165 */       this.codeKey = -1;
/* 166 */       this.codeMod = -1;
/* 167 */       this.errorKey.clear();
/*     */       
/* 169 */       if (KEYS.MAIN().get(this.triedcodeMod, this.triedcodeKey) != null && KEYS.MAIN().get(this.triedcodeMod, this.triedcodeKey) != this.key)
/* 170 */         this.errorKey.add(KEYS.MAIN().get(this.triedcodeMod, this.triedcodeKey)); 
/* 171 */       if (this.key.page().get(this.triedcodeMod, this.triedcodeKey) != null && this.key.page().get(this.triedcodeMod, this.triedcodeKey) != this.key) {
/* 172 */         this.errorKey.add(this.key.page().get(this.triedcodeMod, this.triedcodeKey));
/*     */       }
/* 174 */       if (this.key.page() == KEYS.MAIN()) {
/* 175 */         for (KeyPage p : KEYS.pages()) {
/* 176 */           if (p == this.key.page() || p == KEYS.MAIN())
/*     */             continue; 
/* 178 */           if (p.get(this.triedcodeMod, this.triedcodeKey) != null && p.get(this.triedcodeMod, this.triedcodeKey) != this.key) {
/* 179 */             this.errorKey.add(p.get(this.triedcodeMod, this.triedcodeKey));
/*     */           }
/*     */         } 
/*     */       }
/*     */       
/* 184 */       if (this.key.assign(this.triedcodeMod, this.triedcodeKey)) {
/* 185 */         KEYS.get().save();
/* 186 */         this.timer = 5.0D;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 191 */     if (MButt.RIGHT.consumeClick()) {
/* 192 */       hide();
/*     */     }
/* 194 */     if (this.timer > 0.0D && MButt.LEFT.consumeClick()) {
/* 195 */       hide();
/*     */     }
/*     */     
/* 198 */     return false;
/*     */   }
/*     */   
/*     */   void show(Key key) {
/* 202 */     this.key = key;
/* 203 */     this.codeKey = -1;
/* 204 */     this.codeMod = -1;
/* 205 */     this.triedcodeMod = -1;
/* 206 */     this.triedcodeKey = -1;
/* 207 */     this.timer = 0.0D;
/* 208 */     (VIEW.inters()).manager.add(this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void poll(LIST<KeyBoard.KeyEvent> keys) {
/* 214 */     if (this.timer > 0.0D) {
/* 215 */       for (KeyBoard.KeyEvent e : keys) {
/*     */         
/* 217 */         if (e.action() == KeyBoard.KEYACTION.PRESS) {
/* 218 */           hide();
/*     */           
/*     */           return;
/*     */         } 
/*     */       } 
/*     */     }
/* 224 */     for (KeyBoard.KeyEvent e : keys) {
/*     */       
/* 226 */       if (e.action() == KeyBoard.KEYACTION.PRESS) {
/* 227 */         if (e.code() == 256) {
/* 228 */           hide();
/*     */ 
/*     */           
/*     */           return;
/*     */         } 
/*     */         
/* 234 */         if (this.codeMod == -1) {
/* 235 */           this.codeMod = e.code(); continue;
/*     */         } 
/* 237 */         this.codeKey = e.code();
/*     */         continue;
/*     */       } 
/* 240 */       if (e.action() == KeyBoard.KEYACTION.RELEASE && 
/* 241 */         e.code() == this.codeMod) {
/* 242 */         this.codeKey = this.codeMod;
/* 243 */         this.codeMod = -1;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\keyboard\IChange.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */