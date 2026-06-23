/*     */ package view.sett.ui.subject;
/*     */ 
/*     */ import init.race.bio.BioLine;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HCLASSES;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.text.Font;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.GETTER;
/*     */ import util.gui.table.GTableBuilder;
/*     */ 
/*     */ final class SInfoDesc
/*     */   extends GuiSection
/*     */ {
/*     */   private final AInfo ss;
/*  23 */   private Str str = new Str(1024);
/*  24 */   private int lines = 0;
/*  25 */   private final int width = 512;
/*     */   
/*  27 */   private int[] starts = Alloc.ii(128);
/*  28 */   private int[] ends = Alloc.ii(128);
/*  29 */   private COLOR[] cols = new COLOR[128];
/*     */   
/*  31 */   private final Font font = (UI.FONT()).M;
/*     */   
/*  33 */   private final LIST<Str> impr = (LIST<Str>)new ArrayList((Object[])new Str[] {
/*  34 */         new Str(64), 
/*  35 */         new Str(64), 
/*  36 */         new Str(64), 
/*  37 */         new Str(64)
/*     */       });
/*     */ 
/*     */   
/*     */   public SInfoDesc(AInfo ss, int height) {
/*  42 */     this.ss = ss;
/*     */     
/*  44 */     for (int i = 0; i < this.cols.length; i++)
/*  45 */       this.cols[i] = COLOR.WHITE100; 
/*  46 */     GTableBuilder b = new GTableBuilder()
/*     */       {
/*     */         public int nrOFEntries()
/*     */         {
/*  50 */           return SInfoDesc.this.lines;
/*     */         }
/*     */       };
/*     */     
/*  54 */     int li = (height - 10) / this.font.height();
/*  55 */     b.column(null, 512, new GTableBuilder.GRowBuilder()
/*     */         {
/*     */           public RENDEROBJ build(final GETTER<Integer> ier)
/*     */           {
/*  59 */             return (RENDEROBJ)new RENDEROBJ.RenderImp(512, SInfoDesc.this.font.height())
/*     */               {
/*     */                 public void render(SPRITE_RENDERER r, float ds)
/*     */                 {
/*  63 */                   int s = (SInfoDesc.null.access$0(SInfoDesc.null.this)).starts[((Integer)ier.get()).intValue()];
/*  64 */                   int e = (SInfoDesc.null.access$0(SInfoDesc.null.this)).ends[((Integer)ier.get()).intValue()];
/*  65 */                   (SInfoDesc.null.access$0(SInfoDesc.null.this)).cols[((Integer)ier.get()).intValue()].bind();
/*  66 */                   (SInfoDesc.null.access$0(SInfoDesc.null.this)).font.render(r, (CharSequence)(SInfoDesc.null.access$0(SInfoDesc.null.this)).str, body().x1(), body().y1(), s, e, 1.0D);
/*  67 */                   COLOR.unbind();
/*     */                 }
/*     */               };
/*     */           }
/*     */         });
/*     */     
/*  73 */     body().setDim(16.0D, 1.0D);
/*     */     
/*  75 */     add((RENDEROBJ)b.create(li, false), 16, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/*  83 */     if (this.ss.a == null) {
/*     */       return;
/*     */     }
/*  86 */     this.str.clear();
/*     */     
/*  88 */     int end = 0;
/*  89 */     this.lines = 0;
/*     */     
/*  91 */     if (this.ss.a.indu().clas() == HCLASSES.CITIZEN()) {
/*     */       
/*  93 */       this.str.add(this.ss.a.race().bio().opinionTitle(this.ss.a));
/*  94 */       end = setColor(end, COLOR.WHITE100);
/*  95 */       this.str.NL();
/*     */ 
/*     */       
/*  98 */       this.ss.a.race().bio().opinions(this.impr, this.ss.a);
/*  99 */       for (CharSequence s : this.impr) {
/* 100 */         if (s.length() > 0) {
/* 101 */           this.str.s(4).add('-').s();
/* 102 */           this.str.add(s);
/* 103 */           this.str.NL();
/*     */         } 
/*     */       } 
/* 106 */       end = setColor(end, (GCOLOR.T()).WARNING);
/* 107 */       this.str.NL();
/*     */     } 
/*     */ 
/*     */     
/* 111 */     boolean nl = false;
/* 112 */     for (BioLine d : this.ss.a.race().bio().lines()) {
/*     */       
/* 114 */       CharSequence s = d.get(this.ss.a);
/* 115 */       if (s != null) {
/* 116 */         if (nl)
/* 117 */           for (int i = 0; i < 4; i++) {
/* 118 */             this.str.s();
/*     */           } 
/* 120 */         this.str.add(s);
/* 121 */         nl = d.nl();
/* 122 */         if (nl) {
/* 123 */           this.str.NL(); continue;
/*     */         } 
/* 125 */         this.str.s();
/*     */       } 
/*     */     } 
/* 128 */     end = setColor(end, COLOR.WHITE100);
/* 129 */     this.str.NL();
/*     */ 
/*     */     
/* 132 */     super.render(r, ds);
/*     */   }
/*     */   
/*     */   private int setColor(int end, COLOR color) {
/* 136 */     while (end < this.str.length() && this.lines < this.starts.length) {
/* 137 */       int start = this.font.getStartIndex((CharSequence)this.str, end);
/* 138 */       end = this.font.getEndIndex((CharSequence)this.str, start, 512);
/* 139 */       this.starts[this.lines] = start;
/* 140 */       this.ends[this.lines] = end;
/* 141 */       this.lines++;
/* 142 */       this.cols[this.lines] = color;
/*     */     } 
/* 144 */     return end;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\subject\SInfoDesc.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */